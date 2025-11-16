package com.ec.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminMainController {

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin"; // admin.html
    }

    @GetMapping("/view-orders")
    public String viewOrders() {
        return "view-orders"; // view-orders.html
    }

    @GetMapping("/manage-orders")
    public String manageOrders() {
        return "manage-orders"; // manage-orders.html
    }

    @GetMapping("/messages")
    public String messages() {
        return "messages"; // messages.html
    }

    @GetMapping("/system-logs")
    public String systemLogs() {
        return "system-logs"; // system-logs.html
    }

    @GetMapping("/admin-profile")
    public String adminProfile() {
        return "admin-profile"; // admin-profile.html
    }
}
