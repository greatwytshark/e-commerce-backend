package com.zpay.zpay.services;

import com.zpay.zpay.domain.Fav;
import com.zpay.zpay.domain.Product;

import java.util.List;

public interface FavService {
    List<Fav> findAllByUserId(Integer userId);
    void deleteAllByUserId(Integer userId);
    Long saveProductsNumber(Integer userId);
}
