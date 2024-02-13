package com.zpay.zpay.services.impl;

import com.zpay.zpay.domain.Fav;
import com.zpay.zpay.domain.Product;
import com.zpay.zpay.repository.FavRepo;
import com.zpay.zpay.services.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavServiceImp implements FavService {

    @Autowired
    private FavRepo favRepo;

    @Override
    public List<Fav> findAllByUserId(Integer userId) {
        return favRepo.findAllByUser_Id(userId);
    }

    @Override
    public void deleteAllByUserId(Integer userId) {
        favRepo.deleteAllByUser_Id(userId);
    }

    @Override
    public Long saveProductsNumber(Integer userId) {
        return favRepo.countAllByUser_Id(userId);
    }
}
