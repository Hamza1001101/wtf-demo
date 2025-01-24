package com.example.bankgirodemo.firstdemo;

import com.example.bankgirodemo.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/v1/transactions/firstdemo")
public class TransactionController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final BankA transactionProducer;

    public TransactionController(BankA transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

    @PostMapping
    public String sendTransaction(@RequestBody Transaction transaction) {
        transactionProducer.sendTransaction(transaction);
        logger.info("Transaction sent : '{}'", transaction);
        return "Transaction sent successfully!";
    }
}

