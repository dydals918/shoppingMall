package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class ItemReview {

    @Id
    @Column(name = "item_review_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_no")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    private String contents;

    private int score;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    private String reply;

    private Date replyDate;

}
