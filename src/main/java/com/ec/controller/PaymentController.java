/*
package com.ec.controller;

import com.ec.entity.PaymentDetails;
import com.ec.entity.Orders;
import com.ec.service.PaymentService;
import com.ec.service.CartService;
import com.ec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;   // ADD THIS

    // Show payment page
    @GetMapping("/payment")
    public String showPaymentPage() {
        return "payment";
    }

    // Handle form submit
    @PostMapping("/processPayment")
    public String processPayment(@ModelAttribute PaymentDetails pd) {

        // Save payment details in DB
        PaymentDetails saved = paymentService.savePayment(pd);

        Long userId = 1L;  // static (later make dynamic)

        // Create orders from cart items
        cartService.getCartItems(userId).forEach(item -> {
            Orders order = new Orders(
                    userId,
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getPrice() * item.getQuantity(),
                    "Paid",        // payment status
                    "Pending",     // delivery status
                    LocalDate.now()
            );

            orderService.createOrder(order);
        });

        // Calculate total amount
        double totalAmount = cartService.calculateTotal(userId);

        // Clear cart after successful payment
        cartService.clearCart(userId);

        // Redirect to bill page
        return "redirect:/bill"
                + "?mobile=" + saved.getMobileNumber()
                + "&paymentMode=" + saved.getPaymentMethod()
                + "&totalAmount=" + totalAmount;
    }

}
*/










package com.ec.controller;

import com.ec.entity.PaymentDetails;
import com.ec.service.PaymentService;
import com.ec.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    // Show payment page
    @GetMapping("/payment")
    public String showPaymentPage() {
        return "payment";
    }

    // Handle form submit
    @PostMapping("/processPayment")
    public String processPayment(@ModelAttribute PaymentDetails pd) {

        // Save in DB
        PaymentDetails saved = paymentService.savePayment(pd);

        // Total amount
        double totalAmount = cartService.calculateTotal(1L);

        return "redirect:/bill"
                + "?mobile=" + saved.getMobileNumber()
                + "&paymentMode=" + saved.getPaymentMethod()
                + "&totalAmount=" + totalAmount;
    }

}
