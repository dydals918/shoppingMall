package com.example.shoppingMall.controller;

import com.example.shoppingMall.dto.memberDTO.LoginDTO;
import com.example.shoppingMall.dto.memberDTO.SignUpDTO;
import com.example.shoppingMall.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String login(LoginDTO loginDTO, HttpServletRequest httpServletRequest){
        String result = memberService.signIn(loginDTO);

        if (result.equals("PW Error")){
            return "login";
        } else {
            HttpSession session = httpServletRequest.getSession(true);
            session.setAttribute("loginName", result);
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(false);
        if (session != null){
            session.invalidate();
            return "redirect:/";
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String inRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(SignUpDTO signUpDTO) {
        Long createId = memberService.signUp(signUpDTO);
        return "index";
    }

}
