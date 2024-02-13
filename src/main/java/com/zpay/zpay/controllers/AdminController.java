package com.zpay.zpay.controllers;

import com.zpay.zpay.domain.Product;
import com.zpay.zpay.domain.Section;
import com.zpay.zpay.domain.User;
import com.zpay.zpay.repository.ProductRepo;
import com.zpay.zpay.repository.SectionRepo;
import com.zpay.zpay.repository.UserRepo;
import com.zpay.zpay.services.impl.SectionServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SectionRepo sectionRepo;
    @Autowired
    private SectionServiceImpl sectionService;
    @Autowired
    private FavController favController;
    @Autowired
    private  CartController cartController;

    record newProduct(String name, String description, String imgUrl, int price){
    }

    //For Users
    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @Transactional
    @DeleteMapping("/delete-user/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id){
        this.favController.clearAllSaved(id);
        this.cartController.clearAllCart(id);
        userRepo.deleteById(id);
    }

    //For Products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    @PostMapping("/{sectionId}/product/add")
    public void saveProduct(@PathVariable("sectionId") Long id, @RequestBody newProduct request){
        Section sec = sectionService.findById(id);
        Product product = new Product();
        product.setName(request.name);
        product.setDescription(request.description);
        product.setImgUrl(request.imgUrl);
        product.setPrice(request.price);
        product.setSection(sec);
        productRepo.save(product);
    }
    @PutMapping("/{sectionId}/product/update/{productId}")
    public void updateProduct(@RequestBody newProduct request, @PathVariable("productId") Long id,
                              @PathVariable("sectionId") Long secId){
        Section sec = sectionService.findById(secId);
        Product product = new Product();
        product.setSection(sec);
        product.setId(id);
        product.setName(request.name);
        product.setDescription(request.description);
        product.setImgUrl(request.imgUrl);
        product.setPrice(request.price);
        productRepo.save(product);
    }



    @DeleteMapping("/product/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Long id){
        productRepo.deleteById(id);
    }
}
