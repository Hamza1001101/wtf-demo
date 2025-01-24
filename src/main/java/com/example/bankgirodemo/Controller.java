package com.example.bankgirodemo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class Controller {


    final TransactionProducer transactionProducer;

    public Controller(TransactionProducer transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

//    @PostMapping
//    public ResponseEntity<?> pushTransactions(@RequestBody Transaction transaction) {
//        transactionProducer.sendTransaction(transaction);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
