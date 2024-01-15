package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Delivery {

    @Id
    @Column(name = "delivery_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    private String address;

    protected Delivery() {
    }

    public static Delivery saveDelivery(Member member, String address){

        Delivery delivery = new Delivery();
        delivery.member = member;
        delivery.address = address;
        return delivery;

    }

}
