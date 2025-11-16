package com.ec.controller;

import com.ec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/my-orders")
    public String userOrders(Model model) {

        Long userId = 1L; // later use logged-in user
        model.addAttribute("orders", orderService.getUserOrders(userId));

        return "my-orders";
    }
    
    @GetMapping("/user/order/cancel/{id}")
    public String cancelUserOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/my-orders";
    }

}
