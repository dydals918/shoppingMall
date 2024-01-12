package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Item {

    @Id
    @Column(name = "item_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_no")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_no")
    private Seller seller;

    private String name;

    private String detail;

    private int price;

    private String imgUrl;

    private int stock;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

}
