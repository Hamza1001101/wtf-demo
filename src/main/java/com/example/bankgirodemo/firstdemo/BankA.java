package com.example.bankgirodemo.firstdemo;

import com.example.bankgirodemo.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


public class BankA {

    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(BankA.class);

    public BankA(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransaction(Transaction transaction) {
        kafkaTemplate.send("transactions", transaction);
        logger.info("Transaction sent to transactions: {}", transaction);
    }


    @KafkaListener(topics = "acknowledgments", groupId = "bank-a-group")
    public void acknowledgeTransaction(Transaction transaction) {
        logger.info("Transaction acknowledged to transactions: {}", transaction.transactionId());
    }
}
