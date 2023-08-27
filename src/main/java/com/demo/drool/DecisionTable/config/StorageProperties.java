package com.demo.drool.DecisionTable.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageProperties {
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}