package com.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.entity.PaymentDetails;
import com.ec.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    public PaymentDetails savePayment(PaymentDetails pd) {
        return paymentRepo.save(pd);
    }

    public PaymentDetails getById(Long id) {
        return paymentRepo.findById(id).orElse(null);
    }
}
