package com.example.shoppingMall.dto.memberDTO;

import lombok.Getter;

@Getter
public class LoginDTO {

    private String memberId;
    private String memberPw;

    public LoginDTO(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }
}
