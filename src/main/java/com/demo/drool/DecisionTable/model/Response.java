package com.demo.drool.DecisionTable.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private WorkflowDecisionLabel.WorkflowDecisionLabelEnum workflowDecisionLabel;
}
