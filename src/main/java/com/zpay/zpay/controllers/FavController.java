package com.zpay.zpay.controllers;

import com.zpay.zpay.domain.Fav;
import com.zpay.zpay.domain.Product;
import com.zpay.zpay.domain.User;
import com.zpay.zpay.repository.FavRepo;
import com.zpay.zpay.repository.ProductRepo;
import com.zpay.zpay.repository.UserRepo;
import com.zpay.zpay.services.FavService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saved")
public class FavController {
    @Autowired
    private FavService favService;
    @Autowired
    private FavRepo favRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{userId}/all")
    List<Fav> getSavedProducts(@PathVariable("userId") Integer userId){
        return favService.findAllByUserId(userId);
    }

    @PostMapping("/{userId}/add/{productId}")
    void addSavedProduct(@PathVariable("userId") Integer userId, @PathVariable("productId") Long productId){
        Product item = productRepo.findById(productId).get();
        User user = userRepo.findById(userId).get();

        Fav fav = new Fav();
        fav.setProduct(item);
        fav.setUser(user);
        favRepo.save(fav);
    }

    @GetMapping("/{userId}/number")
    Long savedProductsNumber(@PathVariable("userId") Integer userId){
        return favService.saveProductsNumber(userId);
    }

    @DeleteMapping("/delete/{favId}")
    void deleteSavedProduct(@PathVariable("favId") Long favId){
        favRepo.deleteById(favId);
    }

    @Transactional
    @DeleteMapping("/delete/all/{userId}")
    void  clearAllSaved(@PathVariable("userId") Integer userId){
        favRepo.deleteAllByUser_Id(userId);
    }
}
