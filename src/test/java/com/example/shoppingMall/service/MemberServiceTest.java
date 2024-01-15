package com.example.shoppingMall.service;

import com.example.shoppingMall.entity.Delivery;
import com.example.shoppingMall.entity.Member;
import com.example.shoppingMall.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원생성(){

        Member member1 = Member.createMember("k", "123", "kim", "남");

        Long id = memberRepository.save(member1);
        System.out.println("멤버 ID : " + id);
        memberRepository.saveDelivery(id, "신암동");

    }

    @Test
    public void 로그인(){

        Member member1 = Member.createMember("k", "123", "kim", "남");
        Long id = memberRepository.save(member1);

        Member idMember = memberRepository.findOne(id);
        Member nameMember = memberRepository.findByMemberId("k");

        Assertions.assertEquals(idMember.getId(), nameMember.getId());

    }

}