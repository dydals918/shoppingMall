package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ItemImageUrl {

    @Id
    @Column(name = "item_img_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_no")
    private Item item;

    private String imgUrl;

}
