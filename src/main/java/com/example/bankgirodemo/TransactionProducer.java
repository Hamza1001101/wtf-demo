package com.example.bankgirodemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TransactionProducer {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    final KafkaTemplate<String, Transaction> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void sendTransaction() {
        var transaction = generateRandomTransaction();
        //kafkaTemplate.send("transactions", transaction);

        var date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault())
                .format(Instant.now());

        logger.info("sent successfully transaction with id {} at {}", transaction.transactionId(), date);
    }


    private Transaction generateRandomTransaction() {
        var senderAccount = "ACC" + ThreadLocalRandom.current().nextInt(1000, 9999);
        var receiverAccount = "ACC" + ThreadLocalRandom.current().nextInt(1000, 9999);
        var amount = ThreadLocalRandom.current().nextDouble(10.0, 10000.0);
        return new Transaction(UUID.randomUUID(), senderAccount, receiverAccount, amount);
    }



}
