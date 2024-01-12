package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class SellerCollect {

    @Id
    @Column(name = "seller_collect_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "seller_no")
    private Seller seller;

}
