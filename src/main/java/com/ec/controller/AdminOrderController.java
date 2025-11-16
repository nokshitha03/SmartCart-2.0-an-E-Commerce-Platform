package com.ec.controller;

import com.ec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/manage-orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "manage-orders";
    }

    @GetMapping("/order/approve/{id}")
    public String approveOrder(@PathVariable Long id) {
        orderService.updateStatus(id, "Delivered");
        return "redirect:/admin/manage-orders";
    }

    @GetMapping("/order/cancel/{id}")
    public String cancelOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/admin/manage-orders";
    }
}
