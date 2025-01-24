package com.example.bankgirodemo;

import java.util.UUID;

public record Transaction(UUID transactionId, String senderAccount, String receiverAccount,

                          double amount) {
}
