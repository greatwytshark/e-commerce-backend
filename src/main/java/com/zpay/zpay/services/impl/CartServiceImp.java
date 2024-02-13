package com.zpay.zpay.services.impl;

import com.zpay.zpay.domain.Cart;
import com.zpay.zpay.domain.Product;
import com.zpay.zpay.repository.CartRepo;
import com.zpay.zpay.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartRepo cartRepo;

    @Override
    public List<Cart> findAllByUserId(Integer userId) {
        return cartRepo.findAllByUser_Id(userId);
    }
}
