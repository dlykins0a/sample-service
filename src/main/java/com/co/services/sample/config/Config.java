package com.co.services.sample.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Autowired
    private Environment environment;
  
    private final Logger log = LoggerFactory.getLogger(Config.class);

    String serverName = environment.getProperty("environment.servername")
    String port = environment.getProperty("environment.dbport")
    String databaseName = environment.getProperty("environment.dbname")
    String userName = environment.getProperty("environment.username")
    String password = environment.getProperty("environment.password")

    // MS SQL Datasource
    @Primary
    @Bean("mainDataSource")
    public DataSource mainDataSource() {
        String envSample = environment.getProperty("environment.username");
        System.out.println("logging env var from yml" + envSample);
        log.info("********************************* logging env var from yml");
        log.info(envSample);
        log.info("********************************* Creating mainDataSource");
        HikariConfig config = new HikariConfig();

        config.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        String url = "jdbc:microsoft:sqlserver://" + serverName + ":" + port + "?useServerPrepStmts=false&rewriteBatchedStatements=true&jdbcCompliantTruncation=false";
        config.setJdbcUrl(url);
        config.addDataSourceProperty("serverName", serverName);
        config.addDataSourceProperty("portNumber", port);
        config.addDataSourceProperty("databaseName", databaseName);

        config.setUsername(userName);
        config.setPassword(password);
        config.setMaximumPoolSize(30);

        // Default is 60 seconds
        config.setConnectionTimeout(60*1000);

        HikariDataSource ds = new HikariDataSource(config);

        return ds;
    }

    @Bean("mainJdbcTemplate")
    public JdbcTemplate mainJdbcTemplate() {
        return new JdbcTemplate(mainDataSource());
    }
}

