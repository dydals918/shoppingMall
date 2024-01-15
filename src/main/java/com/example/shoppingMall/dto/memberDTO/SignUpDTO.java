package com.example.shoppingMall.dto.memberDTO;

import lombok.Getter;

@Getter
public class SignUpDTO {

    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberGender;
    private String address;

    public SignUpDTO(String memberId, String memberPw, String memberName, String memberGender, String address) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.address = address;
    }
}
