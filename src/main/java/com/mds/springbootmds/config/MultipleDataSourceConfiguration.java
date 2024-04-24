package com.mds.springbootmds.config;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultipleDataSourceConfiguration {

  @ConfigurationProperties(prefix = "spring.datasource.mysql")
  @Bean
  public DataSourceProperties mySQLDataSourceProperties() {
    return new DataSourceProperties();
  }

  @ConfigurationProperties(prefix = "spring.datasource.postgres")
  @Bean
  public DataSourceProperties postgreSQLDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Primary
  @Bean(name = "mySQLDataSource")
  public DataSource mySQLDataSource() {
    return mySQLDataSourceProperties().initializeDataSourceBuilder().build();
  }

  @Bean(name = "postgreSQLDataSource")
  public DataSource postgreSQLDataSource() {
    return postgreSQLDataSourceProperties().initializeDataSourceBuilder().build();
  }
}
