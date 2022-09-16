// package com.co.services.sample;

// import com.zaxxer.hikari.HikariConfig;
// import com.zaxxer.hikari.HikariDataSource;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.annotation.*;
// import org.springframework.jdbc.core.JdbcTemplate;

// import javax.sql.DataSource;

// @Configuration
// public class Config {

//     private final Logger log = LoggerFactory.getLogger(Config.class);

//     String serverName = "donssqlv1.database.usgovcloudapi.net";
//     String port = "1433";
//     String databaseName = "MCSSQL-POCV1";
//     String userName = "donssqllogin";
//     String password = "dlykins0A";

//     // MS SQL Datasource
//     @Primary
//     @Bean("mainDataSource")
//     public DataSource mainDataSource() {
//         log.info("********************************* Creating mainDataSource");
//         HikariConfig config = new HikariConfig();

//         config.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
//         String url = "jdbc:microsoft:sqlserver://" + serverName + ":" + port + "?useServerPrepStmts=false&rewriteBatchedStatements=true&jdbcCompliantTruncation=false";
//         config.setJdbcUrl(url);
//         config.addDataSourceProperty("serverName", serverName);
//         config.addDataSourceProperty("portNumber", port);
//         config.addDataSourceProperty("databaseName", databaseName);

//         config.setUsername(userName);
//         config.setPassword(password);
//         config.setMaximumPoolSize(30);

//         // Default is 60 seconds
//         config.setConnectionTimeout(60*1000);

//         HikariDataSource ds = new HikariDataSource(config);

//         return ds;
//     }

//     @Bean("mainJdbcTemplate")
//     public JdbcTemplate mainJdbcTemplate() {
//         return new JdbcTemplate(mainDataSource());
//     }
// }


