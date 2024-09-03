package com.kpl.payment.service;

import com.kpl.payment.model.PaymentDetails;
import com.kpl.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public ResponseEntity<String> save(PaymentDetails cardDetails)
    {
        Date expiryDate=cardDetails.getExpiryDate();

        Date now= new Date();
        if(expiryDate.before(now)){
            cardDetails.setPaymentStatus("Payment failed");
            cardDetails.setFailureReason("Your card is expired");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cardDetails.toString());
        }


        try {
            paymentRepository.save(cardDetails);
            cardDetails.setPaymentStatus("Successfully Paid");
            return ResponseEntity.ok(cardDetails.toString());
        }catch (Exception e)
        {
            cardDetails.setPaymentStatus("Payment Failed");
            cardDetails.setFailureReason(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cardDetails.toString());
        }
    }
}
