package com.demo.drool.DecisionTable.service;

import com.demo.drool.DecisionTable.model.RuleExecution;

import java.util.List;

public interface RuleExecutionService {
    List<RuleExecution> applyRule(RuleExecution ruleExecution);
}
