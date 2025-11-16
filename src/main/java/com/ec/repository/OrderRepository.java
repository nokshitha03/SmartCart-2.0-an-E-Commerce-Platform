package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ec.entity.Orders;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByUserId(Long userId);
}
