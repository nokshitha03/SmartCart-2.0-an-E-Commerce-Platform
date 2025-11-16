package com.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class BillController {

    @GetMapping("/bill")
    public String showBill(
//            @RequestParam String name,
//            @RequestParam String email,
            @RequestParam String mobile,
            @RequestParam String paymentMode,
            @RequestParam double totalAmount,
            Model model
    ) {

        LocalDate today = LocalDate.now();
        LocalDate delivery = today.plusDays((int) (Math.random() * 5 + 3)); // 3–7 days random

//        model.addAttribute("name", name);
//        model.addAttribute("email", email);
        model.addAttribute("mobile", mobile);
        model.addAttribute("paymentMode", paymentMode);
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("orderDate", today);
        model.addAttribute("deliveryDate", delivery);

        return "bill";
    }
}
