package com.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ec.entity.Cart;
import com.ec.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // for now we assume one static user (id=1)
    private Long userId = 1L;
    
    

    @GetMapping
    public String viewCart(Model model) {
        List<Cart> cartItems = cartService.getCartItems(userId);
        double total = cartService.calculateTotal(userId);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        model.addAttribute("userId", userId);
        return "cart";
    }

    @GetMapping("/increase/{id}")
    @ResponseBody
    public String increaseQty(@PathVariable Long id) {
        cartService.increaseQuantity(userId, id);
        return "Quantity increased";
    }

    @GetMapping("/decrease/{id}")
    @ResponseBody
    public String decreaseQty(@PathVariable Long id) {
        cartService.decreaseQuantity(userId, id);
        return "Quantity decreased";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteItem(@PathVariable Long id) {
        cartService.deleteItem(userId, id);
        return "Item deleted";
    }
    
    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId) {
        cartService.addToCart(userId, productId);
        return "redirect:/cart";  // ✅ after adding, redirect to cart.html
    }


    @GetMapping("/clear")
    @ResponseBody
    public String clearCart() {
        cartService.clearCart(userId);
        return "Cart cleared";
    }
}
