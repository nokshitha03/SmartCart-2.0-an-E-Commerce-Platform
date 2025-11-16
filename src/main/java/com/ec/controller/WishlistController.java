package com.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ec.entity.WishlistEntity;
import com.ec.entity.AdmProduct;
import com.ec.service.WishlistService;
import com.ec.service.CartService;
import com.ec.service.AdmProductService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private CartService cartService;

    @Autowired
    private AdmProductService productService;

    // ✅ 1️⃣ Show Wishlist Page
    @GetMapping
    public String viewWishlist(Model model) {
        model.addAttribute("wishlistItems", wishlistService.getAllWishlistItems());
        return "wishlist";
    }

    // ✅ 2️⃣ Add Product to Wishlist (called from home.html)
    @GetMapping("/add/{productId}")
    public String addToWishlist(@PathVariable Long productId) {
        AdmProduct product = productService.getProductById(productId);
        if (product != null) {
            WishlistEntity item = new WishlistEntity();
            item.setProductId(product.getId());
            item.setProductName(product.getName());
            item.setPrice(product.getPrice());
            wishlistService.addToWishlist(item);
        }
        return "redirect:/wishlist"; // redirect to wishlist page after adding
    }

    // ✅ 3️⃣ Move item from Wishlist → Cart
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id) {
        WishlistEntity item = wishlistService.getById(id);
        if (item != null) {
            // Assuming User ID = 1L for now
            cartService.addToCart(1L, item.getProductId());
            wishlistService.deleteFromWishlist(id);
        }
        return "redirect:/cart";
    }

    // ✅ 4️⃣ Delete Single Wishlist Item
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        wishlistService.deleteFromWishlist(id);
        return "redirect:/wishlist";
    }

    // ✅ 5️⃣ Clear All Wishlist Items
    @GetMapping("/clear")
    public String clearWishlist() {
        wishlistService.clearWishlist();
        return "redirect:/wishlist";
    }
}
