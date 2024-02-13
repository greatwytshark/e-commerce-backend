package com.zpay.zpay.domain;

import jakarta.persistence.*;

@Entity
public class Fav {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long favId;
    @OneToOne
    private Product product;
    @ManyToOne
    private User user;

    public Fav() {
    }

    public Fav(Long favId, Product product, User user) {
        this.favId = favId;
        this.product = product;
        this.user = user;
    }

    public Long getFavId() {
        return favId;
    }

    public void setFavId(Long favId) {
        this.favId = favId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
