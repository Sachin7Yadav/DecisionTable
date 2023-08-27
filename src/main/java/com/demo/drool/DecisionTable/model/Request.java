package com.demo.drool.DecisionTable.model;

import lombok.Data;

@Data
public class Request {
    private StepDecision decision;
    private WorkflowDecisionLabel.WorkflowDecisionLabelEnum workflowDecisionLabel;

    public StepDecision getDecision() {
        return decision;
    }

    public WorkflowDecisionLabel.WorkflowDecisionLabelEnum getWorkflowDecisionLabel() {
        return workflowDecisionLabel;
    }
}
