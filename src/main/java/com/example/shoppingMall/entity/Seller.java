package com.example.shoppingMall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Seller {

    @Id
    @Column(name = "seller_no")
    private Long id;

    private String sellerId;
    private String sellerPw;
    private String shoppingMallName;

}
