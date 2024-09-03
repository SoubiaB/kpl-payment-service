package com.kpl.payment.controller;


import com.kpl.payment.model.PaymentDetails;
import com.kpl.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> savePayment(@RequestBody PaymentDetails cardDetails)
    {
        return paymentService.save(cardDetails);
    }

}
