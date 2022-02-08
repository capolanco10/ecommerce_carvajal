package co.com.ecommercecarvajal.platform.infrastructure.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring boot configuration for Datasource runtime
 */

@Configuration
public class DatasourceConfiguration {

    public static final String JPA_DATASOURCE = "datasource-ecommercemanager";

    @Bean(name = JPA_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.db-ecommercemanager")
    public DataSource dataSourceEbusiness() {
        return DataSourceBuilder.create().build();
    }

}
