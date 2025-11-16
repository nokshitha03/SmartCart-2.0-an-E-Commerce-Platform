package com.ec.service;

import com.ec.entity.WishlistEntity;
import com.ec.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public void addToWishlist(WishlistEntity item) {
        wishlistRepository.save(item);
    }

    public List<WishlistEntity> getAllWishlistItems() {
        return wishlistRepository.findAll();
    }

    public void deleteFromWishlist(Long id) {
        wishlistRepository.deleteById(id);
    }

    public void clearWishlist() {
        wishlistRepository.deleteAll();
    }

    public WishlistEntity getById(Long id) {
        return wishlistRepository.findById(id).orElse(null);
    }
}
