package com.example.shoppingMall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Category {

    @Id
    @Column(name = "category_no")
    private Long id;

    private String categoryName;

}
