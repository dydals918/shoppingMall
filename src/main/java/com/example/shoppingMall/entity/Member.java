package com.example.shoppingMall.entity;

import com.example.shoppingMall.enums.MemberRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberRole role;

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
        member.setRole(MemberRole.USER);
        return member;

    }

}
