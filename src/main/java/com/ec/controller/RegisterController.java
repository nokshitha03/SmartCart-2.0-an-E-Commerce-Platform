/*
package com.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    // Show Register Page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";   // register.html
    }

    // When Register Form is submitted → Go to Home
    @PostMapping("/register")
    public String registerUser() {
        return "redirect:/";
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";      // login.html
    }

    // When Login Form is submitted → Go to Home
    @PostMapping("/login")
    public String loginUser() {
        return "redirect:/";
    }
    
    @GetMapping("/profile/view")
    public String userProfile() {
    	return "user";
    }

//    // Home Page
//    @GetMapping("/")
//    public String homePage() {
//        return "home";       // home.html
//    }
    
    
 // Admin-Only Login
    @PostMapping("/adminlogin")
    public String loginAdmin(@RequestParam String username,
                             @RequestParam String password,
                             Model model) {

        // Only Admin Login
        if(username.equals("admin") && password.equals("1234")) {
            return "admin";      // admin.html
        }

        // Invalid credentials → show error
        model.addAttribute("error", "Invalid Admin Credentials!");
        return "login";
    }
}
*/





package com.ec.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ec.entity.AdmProduct;
import com.ec.repository.*;

@Controller
public class RegisterController {
	
	// Intro Page
    @GetMapping("/intro")
    public String introPage() {
        return "intro";   // intro.html
    }

    // Show Register Page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    
    @GetMapping("/profile/view")
    public String userProfile() {
    	return "user";
    }


    // When Register Form is submitted → Go to Home
    @PostMapping("/register")
    public String registerUser() {
        return "home";  
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    
    
    @GetMapping("/Admin")
    public String hello() {
    	return "redirect:/login";
    }
    
    
    


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        // Admin login verification
        if (username.equals("admin") && password.equals("1234")) {
            return "admin";  // admin.html page
        }

        // For any user, open homepage
        return "redirect:/";  // home.html page
    }

}















