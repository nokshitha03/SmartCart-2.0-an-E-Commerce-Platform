package com.ec.service;

import com.ec.entity.Orders;
import com.ec.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    // For User - see orders
    public List<Orders> getUserOrders(Long userId) {
        return repo.findByUserId(userId);
    }

    // For Admin - see all orders
    public List<Orders> getAllOrders() {
        return repo.findAll();
    }

    // Create new order
    public Orders createOrder(Orders order) {
        return repo.save(order);
    }

    // Update order status
    public void updateStatus(Long id, String status) {
        Orders o = repo.findById(id).orElse(null);
        if (o != null) {
            o.setOrderStatus(status);
            repo.save(o);
        }
    }

    // Delete order
    public void deleteOrder(Long id) {
        repo.deleteById(id);
    }
}
