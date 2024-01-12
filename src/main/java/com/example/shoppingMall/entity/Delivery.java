package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Delivery {

    @Id
    @Column(name = "delivery_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    private String address;

}
