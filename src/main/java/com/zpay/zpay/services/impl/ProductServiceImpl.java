package com.zpay.zpay.services.impl;

import com.zpay.zpay.domain.Product;
import com.zpay.zpay.repository.ProductRepo;
import com.zpay.zpay.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> findAllBySectionId(long sectionId) {
        return productRepo.findAllBySection_Id(sectionId);
    }

    @Override
    public Product addProduct(long sectionId, Product product) {
        return null;
    }
}
