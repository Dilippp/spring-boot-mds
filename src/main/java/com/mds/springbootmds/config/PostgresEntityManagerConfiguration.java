package com.mds.springbootmds.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
    basePackages = "com.mds.springbootmds.postgres",
    entityManagerFactoryRef = "postgresSQLEntityManagerFactoryBean",
    transactionManagerRef = "postgresSQLTransactionManager")
public class PostgresEntityManagerConfiguration {

  @Bean
  LocalContainerEntityManagerFactoryBean postgresSQLEntityManagerFactoryBean(
      EntityManagerFactoryBuilder entityManagerFactoryBuilder,
      @Qualifier("postgreSQLDataSource") DataSource dataSource) {
    return entityManagerFactoryBuilder
        .dataSource(dataSource)
        .packages("com.mds.springbootmds.kela")
        .build();
  }

  @Bean
  PlatformTransactionManager postgresSQLTransactionManager(
      @Qualifier("postgresSQLEntityManagerFactoryBean")
          LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
    return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
  }
}
