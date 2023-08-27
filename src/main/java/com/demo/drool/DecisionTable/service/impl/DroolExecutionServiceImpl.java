package com.demo.drool.DecisionTable.service.impl;

import com.demo.drool.DecisionTable.core.DroolConfiguration;
import com.demo.drool.DecisionTable.model.Request;
import com.demo.drool.DecisionTable.model.Response;
import com.demo.drool.DecisionTable.service.DroolExecutionService;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class DroolExecutionServiceImpl implements DroolExecutionService {

    private final DroolConfiguration droolConfiguration;

    @Override
    public Response executeRule(Request request) {
        KieSession kieSession = droolConfiguration.getKieContainer().newKieSession();
        kieSession.insert(request);
        kieSession.fireAllRules();
        return Response.builder()
                .workflowDecisionLabel(request.getWorkflowDecisionLabel())
                .build();
    }

    @Override
    public void refreshRules(Path load) {
        droolConfiguration.updateKieFileSystem(load);
    }
}
