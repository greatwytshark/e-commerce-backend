package com.zpay.zpay.services;

import com.zpay.zpay.domain.Cart;
import com.zpay.zpay.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    List<Cart> findAllByUserId(Integer userId);
}
