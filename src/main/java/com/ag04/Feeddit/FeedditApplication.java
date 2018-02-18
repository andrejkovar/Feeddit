package com.ag04.Feeddit;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class FeedditApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedditApplication.class, args);
	}

}

