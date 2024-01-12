package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ItemCollect {

    @Id
    @Column(name = "item_collect_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "item_no")
    private Item item;

}
