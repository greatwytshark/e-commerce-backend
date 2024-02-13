package com.zpay.zpay.repository;

import com.zpay.zpay.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllBySection_Id(Long sectionId);
    void deleteAllBySection_Id(Long sectionId);
}
