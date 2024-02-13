package com.zpay.zpay.services;

import com.zpay.zpay.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllBySectionId(long sectionId);
    Product addProduct(long sectionId, Product product);
}
