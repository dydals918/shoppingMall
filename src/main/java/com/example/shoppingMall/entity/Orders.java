package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Orders {

    @Id
    @Column(name = "orders_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "item_no")
    private Item item;

    private int quantity;

    private String delivery;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ordersDate;

    private String orderStatus;

}
