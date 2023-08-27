package com.demo.drool.DecisionTable.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuleExecution {
    private String ruleFileName;
    private StepDecision decision;
    private WorkflowDecisionLabel.WorkflowDecisionLabelEnum workflowDecisionLabel;
}
