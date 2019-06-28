package com.testg.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HSCloneApplication {
    private static final Logger log = LoggerFactory.getLogger(HSCloneApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HSCloneApplication.class);
    }
}
