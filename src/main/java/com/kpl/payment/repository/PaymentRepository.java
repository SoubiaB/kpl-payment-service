package com.kpl.payment.repository;

import com.kpl.payment.model.PaymentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentDetails, String> {
}
