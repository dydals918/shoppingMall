package com.example.shoppingMall.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Member {

    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberGender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    protected Member() {
    }

    public static Member createMember(String memberId, String memberPw, String memberName, String memberGender){

        Member member = new Member();
        member.memberId = memberId;
        member.memberPw = memberPw;
        member.memberName = memberName;
        member.memberGender = memberGender;
        return member;

    }
}
