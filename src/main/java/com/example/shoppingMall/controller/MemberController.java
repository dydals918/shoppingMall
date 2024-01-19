package com.example.shoppingMall.controller;

import com.example.shoppingMall.dto.memberDTO.SignUpDTO;
import com.example.shoppingMall.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String inLoginPage(){
        return "login";
    }

//    @PostMapping("/login")
//    public void login(LoginDTO loginDTO, HttpServletRequest httpServletRequest){
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(SecurityMember.getUsername());
//
//        if (result.equals("PW Error")){
//            return "login";
//        } else {
//            HttpSession session = httpServletRequest.getSession(true);
//            session.setAttribute("loginName", result);
//            return "redirect:/";
//        }
//    }

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
    public String register(SignUpDTO signUpDTO, Model model) {

        try{
            SignUpDTO encodSignUpDto = encodePw(signUpDTO);
            memberService.signUp(encodSignUpDto);
            return "index";
        } catch (Exception e){
            return "redirect:/";
        }

    }

    private SignUpDTO encodePw(SignUpDTO signUpDTO){
        SignUpDTO encodeSignUpDto = new SignUpDTO(
                signUpDTO.getMemberId(),
                bCryptPasswordEncoder.encode(signUpDTO.getMemberPw()),
                signUpDTO.getMemberName(),
                signUpDTO.getMemberGender(),
                signUpDTO.getAddress()
        );
        return encodeSignUpDto;
    }

}
