package com.demo.drool.DecisionTable.controller;

import com.demo.drool.DecisionTable.model.Request;
import com.demo.drool.DecisionTable.model.Response;
import com.demo.drool.DecisionTable.service.DroolExecutionService;
import com.demo.drool.DecisionTable.service.StorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
public class Controller {

    private final StorageService storageService;
    private final DroolExecutionService droolExecutionService;

    public Controller(StorageService storageService, DroolExecutionService droolExecutionService) {
        this.storageService = storageService;
        this.droolExecutionService = droolExecutionService;
    }

    @PostMapping(path = "/refresh",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        storageService.store(multipartFile);
        Path load = storageService.load(multipartFile.getName());
        droolExecutionService.refreshRules(load);
        return String.format("You successfully uploaded %s !", multipartFile.getOriginalFilename());
    }


    @PostMapping(path = "/executeRule")
    public Response executeRule(@RequestBody Request request) {
        return droolExecutionService.executeRule(request);
    }

}
