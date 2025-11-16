package com.ec.entity;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // or use User entity later

    @ManyToOne
    @JoinColumn(name = "product_id")
    private AdmProduct product;

    private int quantity;
    private double price; // price per product
    private double subtotal; // quantity * price

    public Cart() {}

    public Cart(Long userId, AdmProduct product, int quantity, double price) {
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = quantity * price;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public AdmProduct getProduct() { return product; }
    public void setProduct(AdmProduct product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
        this.subtotal = this.price * quantity;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { 
        this.price = price;
        this.subtotal = this.price * this.quantity;
    }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}
