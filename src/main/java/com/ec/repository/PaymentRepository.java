package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ec.entity.PaymentDetails;

public interface PaymentRepository extends JpaRepository<PaymentDetails, Long> {

}
