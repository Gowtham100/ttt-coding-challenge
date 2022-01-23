package com.example.ttt_codingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class TttCodingChallengeApplication {

    public static void main(String[] args) {

        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
        SpringApplication.run(TttCodingChallengeApplication.class, args);
    }

}
