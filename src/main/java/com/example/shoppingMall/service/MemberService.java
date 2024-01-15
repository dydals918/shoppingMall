package com.example.shoppingMall.service;

import com.example.shoppingMall.dto.memberDTO.LoginDTO;
import com.example.shoppingMall.dto.memberDTO.SignUpDTO;
import com.example.shoppingMall.entity.Member;
import com.example.shoppingMall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long signUp(SignUpDTO signUpDTO){
        Member member = Member.createMember(signUpDTO.getMemberId(), signUpDTO.getMemberPw(), signUpDTO.getMemberName(), signUpDTO.getMemberGender());

        Long saveId = memberRepository.save(member);
        memberRepository.saveDelivery(saveId, signUpDTO.getAddress());

        return saveId;
    }

    public String signIn(LoginDTO loginDTO){
        Member findMember = memberRepository.findByMemberId(loginDTO.getMemberId());

        if (findMember.getMemberPw().equals(loginDTO.getMemberPw())){
            return findMember.getMemberName();
        } else {
            return "PW Error";
        }
    }

}
