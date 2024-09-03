package com.kpl.payment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("PaymentDetails")
public class PaymentDetails {
    @Id
    private String cardId;

    private Long cardNumber;

    private Integer cvv;

    private Date expiryDate;

    private String orderNumber;

    private double amount;

    private String paymentStatus;

    private String failureReason;
}
