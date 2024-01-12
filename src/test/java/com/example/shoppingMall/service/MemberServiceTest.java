package com.example.shoppingMall.service;

import com.example.shoppingMall.entity.Member;
import com.example.shoppingMall.repository.MemberRepository;
import com.example.shoppingMall.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepositoryImpl memberRepository;

    @Test
    public void 회원생성(){

        Member member1 = Member.createMember("k", "123", "kim", "남");

        Long id = memberRepository.save(member1);

        System.out.println(id);
    }

}