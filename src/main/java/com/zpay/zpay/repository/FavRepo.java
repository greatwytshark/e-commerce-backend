package com.zpay.zpay.repository;

import com.zpay.zpay.domain.Fav;
import com.zpay.zpay.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavRepo extends JpaRepository<Fav, Long> {
    List<Fav> findAllByUser_Id(Integer userId);
    void deleteAllByUser_Id(Integer userId);
    Long countAllByUser_Id(Integer userId);
}
