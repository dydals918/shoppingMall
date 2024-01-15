package com.example.shoppingMall.controller;

import com.example.shoppingMall.dto.SignUpDTO;
import com.example.shoppingMall.entity.Member;
import com.example.shoppingMall.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String inLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String

    @GetMapping("/register")
    public String inRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String RegisterPage(SignUpDTO signUpDTO) {
        Long createId = memberService.signUp(signUpDTO);
        return "index";
    }

}
