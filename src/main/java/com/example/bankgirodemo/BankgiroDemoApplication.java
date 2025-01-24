package com.example.bankgirodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class BankgiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankgiroDemoApplication.class, args);
    }

}
