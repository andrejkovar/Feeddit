package com.ag04.Feeddit.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {

        URI dbUri;
        try{
            dbUri = new URI(System.getenv("DATABASE_URL"));
        }catch (NullPointerException exc){
            dbUri = new URI("postgres://zhndouehzkhvje:67900db285952f1062f475394d5264b848519b3249784759de0b4293aae0dc5b@ec2-54-247-95-125.eu-west-1.compute.amazonaws.com:5432/d4jitkk9m76f5q?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
        }

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];

        StringBuilder dbUrl = new StringBuilder(128);
        dbUrl.append("jdbc:postgresql://")
                .append(dbUri.getHost()).append(":")
                .append(dbUri.getPort())
                .append(dbUri.getPath());

        String query = dbUri.getQuery();
        if (null != query && !query.isEmpty()) {
            dbUrl.append("?").append(query);
        }

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl.toString());
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
