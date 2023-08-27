package com.demo.drool.DecisionTable.service;

import com.demo.drool.DecisionTable.model.Request;
import com.demo.drool.DecisionTable.model.Response;

import java.nio.file.Path;

public interface DroolExecutionService {
    Response executeRule(Request request);

    void refreshRules(Path load);
}
