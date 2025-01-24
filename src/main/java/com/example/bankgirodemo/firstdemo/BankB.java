package com.example.bankgirodemo.firstdemo;

import com.example.bankgirodemo.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


public class BankB {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public BankB(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @KafkaListener(topics = "transactions", groupId = "bank-b-group")
    public void processTransaction(Transaction transaction) {
        logger.info("Received transaction: {}", transaction);

        // Simulate processing and acknowledgment
        sendAcknowledgment(transaction);
    }


    private void sendAcknowledgment(Transaction transaction) {
        kafkaTemplate.send("acknowledgments", transaction);
        logger.info("Acknowledgment sent for transaction: {}", transaction.transactionId());
    }
}
