package com.junoth.aws.sqssample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(
		exclude = {
                ContextInstanceDataAutoConfiguration.class
        }
)
@EnableScheduling
public class SqsSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqsSampleApplication.class, args);
    }

}
