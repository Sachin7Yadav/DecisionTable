package com.demo.drool.DecisionTable.config;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class StorageProperties {
    private String location = "upload-dir";

    public void setLocation(String location) {
        this.location = location;
    }

}