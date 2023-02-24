package com.paneladev.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "spring")
public class DataSourceProperties {

    private final Map<Object, Object> datasources = new LinkedHashMap<>();

    public Map<Object, Object> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, Map<String, String>> datasources) {
        datasources
                .forEach((key, value) -> this.datasources.put(key, convert(value)));
    }

    private DataSource convert(Map<String, String> source) {
        return DataSourceBuilder.create()
                .url(source.get("url"))
                .driverClassName(source.get("driver-class-name"))
                .username(source.get("username"))
                .password(source.get("password"))
                .build();
    }
}
