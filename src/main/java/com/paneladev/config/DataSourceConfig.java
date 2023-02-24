package com.paneladev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfig(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource getDataSource() {
        TenantAwareRoutingDataSource tenantAwareRoutingDataSource = new TenantAwareRoutingDataSource();
        tenantAwareRoutingDataSource.setTargetDataSources(dataSourceProperties.getDatasources());
        tenantAwareRoutingDataSource.afterPropertiesSet();
        return tenantAwareRoutingDataSource;
    }
}
