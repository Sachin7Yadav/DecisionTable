package com.demo.drool.DecisionTable.model;

import lombok.Data;

@Data
public class WorkflowDecisionLabel {
    private WorkflowDecisionLabelEnum workflowDecisionLabelEnum;

    public enum WorkflowDecisionLabelEnum {
        OPTION_1,
        OPTION_2,
        OPTION_3,
        OPTION_4,
        DEFAULT;
    }
}
