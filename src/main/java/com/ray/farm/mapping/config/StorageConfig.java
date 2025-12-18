package com.ray.farm.mapping.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.storage")
public record StorageConfig(String rootDir) { }
