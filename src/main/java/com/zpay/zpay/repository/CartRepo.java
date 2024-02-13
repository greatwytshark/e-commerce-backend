package com.zpay.zpay.repository;

import com.zpay.zpay.domain.Cart;
import com.zpay.zpay.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUser_Id(Integer userId);
    void deleteAllByUser_Id(Integer userId);
}
