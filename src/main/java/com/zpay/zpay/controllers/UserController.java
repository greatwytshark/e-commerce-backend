package com.zpay.zpay.controllers;

import com.zpay.zpay.domain.Product;
import com.zpay.zpay.domain.Section;
import com.zpay.zpay.repository.ProductRepo;
import com.zpay.zpay.repository.SectionRepo;
import com.zpay.zpay.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private SectionRepo secRepo;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    @GetMapping("/products/{sectionId}/all")
    public List<Product> getProducts(@PathVariable("sectionId") long id){

        return productService.findAllBySectionId(id);
    }

    @GetMapping("/products/{productId}")
    Product viewProduct(@PathVariable("productId") Long productId){
        return productRepo.findById(productId).get();
    }

    @GetMapping("/sections")
    public List<Section> getSections(){
        return secRepo.findAll();
    }
}
