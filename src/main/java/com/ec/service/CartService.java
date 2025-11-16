package com.ec.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ec.entity.Cart;
import com.ec.entity.AdmProduct;
import com.ec.repository.AdmProductRepository;
import com.ec.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private AdmProductRepository productRepo;

    // ✅ Get all cart items for a user
    public List<Cart> getCartItems(Long userId) {
        return cartRepo.findByUserId(userId);
    }

    // ✅ Add product to cart
    public void addToCart(Long userId, Long productId) {
        AdmProduct product = productRepo.findById(productId).orElse(null);
        if (product == null) return;

        Cart existing = cartRepo.findByUserId(userId)
                .stream()
                .filter(c -> c.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + 1);
            existing.setSubtotal(existing.getPrice() * existing.getQuantity());
            cartRepo.save(existing);
        } else {
            Cart c = new Cart();
            c.setUserId(userId);
            c.setProduct(product);
            c.setPrice(product.getPrice());
            c.setQuantity(1);
            c.setSubtotal(product.getPrice());
            cartRepo.save(c);
        }
    }

    // ✅ Increase quantity
    public void increaseQuantity(Long userId, Long cartId) {
        Cart c = cartRepo.findById(cartId).orElse(null);
        if (c != null && c.getUserId().equals(userId)) {
            c.setQuantity(c.getQuantity() + 1);
            c.setSubtotal(c.getPrice() * c.getQuantity());
            cartRepo.save(c);
        }
    }

    // ✅ Decrease quantity
    public void decreaseQuantity(Long userId, Long cartId) {
        Cart c = cartRepo.findById(cartId).orElse(null);
        if (c != null && c.getUserId().equals(userId)) {
            if (c.getQuantity() > 1) {
                c.setQuantity(c.getQuantity() - 1);
                c.setSubtotal(c.getPrice() * c.getQuantity());
                cartRepo.save(c);
            } else {
                cartRepo.delete(c);
            }
        }
    }

    // ✅ Delete one item
    public void deleteItem(Long userId, Long cartId) {
        Cart c = cartRepo.findById(cartId).orElse(null);
        if (c != null && c.getUserId().equals(userId)) {
            cartRepo.delete(c);
        }
    }

    // ✅ Clear entire cart
    public void clearCart(Long userId) {
        cartRepo.deleteByUserId(userId);
    }

    // ✅ Calculate total price
    public double calculateTotal(Long userId) {
        return getCartItems(userId)
                .stream()
                .mapToDouble(Cart::getSubtotal)
                .sum();
    }
}
