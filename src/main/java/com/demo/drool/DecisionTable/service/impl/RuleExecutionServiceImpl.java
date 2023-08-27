package com.demo.drool.DecisionTable.service.impl;

import com.demo.drool.DecisionTable.model.RuleExecution;
import com.demo.drool.DecisionTable.service.RuleExecutionService;
import com.demo.drool.DecisionTable.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.command.Command;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class RuleExecutionServiceImpl implements RuleExecutionService {

    private final StorageService service;

    @Override
    @SuppressWarnings({"rawtype", "unchecked"})
    public List<RuleExecution> applyRule(RuleExecution ruleExecution) {
        String fileName = ruleExecution.getRuleFileName();

        if (Objects.nonNull(fileName)) {
            fileName = ruleExecution.getRuleFileName();
        } else {
            fileName = "StepDecision.xlsx";
        }
        Path load = service.load(fileName);
        try (InputStream is = new FileInputStream(load.toFile())) {
            SpreadsheetCompiler sc = new SpreadsheetCompiler();
            String rules = sc.compile(is, InputType.XLS);
            log.info("DRL file generated");
            StatelessKieSession kSession = new KieHelper().addContent(rules, ResourceType.DRL).build().newStatelessKieSession();
            log.info("Executing rules ...");
            List<Command<RuleExecution>> commands = List.<Command<RuleExecution>>of(
                    CommandFactory.newInsert(ruleExecution),
                    CommandFactory.newFireAllRules(),
                    CommandFactory.newGetObjects(new ClassObjectFilter(RuleExecution.class), "output")
            );
            ExecutionResults results = kSession.execute(CommandFactory.newBatchExecution(commands));
            return (List<RuleExecution>) results.getValue("output");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
