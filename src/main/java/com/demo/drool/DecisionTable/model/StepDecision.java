package com.demo.drool.DecisionTable.model;

import lombok.Data;

@Data
public class StepDecision {
    private DecisionType decisionType;
    private DecisionLabel decisionLabel;

    public enum DecisionType {
        PASSED,
        WARNING,
        REJECTED,
        NOT_EXECUTED;
    }

    public enum DecisionLabel {
        BAD_REQUEST,
        PERMISSION_DENIED,
        TECHNICAL_ERROR,
        PRECONDITION_NOT_FULFILLED;
    }
}
