package com.demo.drool.DecisionTable.controller;

import com.demo.drool.DecisionTable.model.RuleExecution;
import com.demo.drool.DecisionTable.service.RuleExecutionService;
import com.demo.drool.DecisionTable.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final StorageService storageService;
    private final RuleExecutionService ruleExecutionService;

    @PostMapping(path = "/uploadRule", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        storageService.store(multipartFile);
        Path load = storageService.load(multipartFile.getName());
        return String.format("You successfully uploaded %s !", multipartFile.getOriginalFilename());
    }

    @PostMapping(path = "/applyRule")
    public List<RuleExecution> applyRule(@RequestBody RuleExecution ruleExecution) {
        return ruleExecutionService.applyRule(ruleExecution);
    }

}
