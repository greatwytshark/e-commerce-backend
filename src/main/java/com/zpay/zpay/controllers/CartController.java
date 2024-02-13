package com.zpay.zpay.controllers;

import com.zpay.zpay.domain.Cart;
import com.zpay.zpay.domain.Product;
import com.zpay.zpay.domain.User;
import com.zpay.zpay.repository.CartRepo;
import com.zpay.zpay.repository.ProductRepo;
import com.zpay.zpay.repository.UserRepo;
import com.zpay.zpay.services.CartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{userId}/all")
    public List<Cart> getCartProducts(@PathVariable("userId") Integer userId){
        return cartService.findAllByUserId(userId);
    }

    @PostMapping("/{userId}/add/{productId}")
    public void addToCart(@PathVariable("userId") Integer userId, @PathVariable("productId") Long productId){
        Product item = productRepo.findById(productId).get();
        User user = userRepo.findById(userId).get();

        Cart cart = new Cart();
        cart.setProduct(item);
        cart.setUser(user);
        cartRepo.save(cart);
    }

    @DeleteMapping("/delete/{cartId}")
    public void deleteCartItem(@PathVariable("cartId") Long cartId){
        cartRepo.deleteById(cartId);
    }

    @Transactional
    @DeleteMapping("/delete/all/{userId}")
    void  clearAllCart(@PathVariable("userId") Integer userId){
        cartRepo.deleteAllByUser_Id(userId);
    }
}
