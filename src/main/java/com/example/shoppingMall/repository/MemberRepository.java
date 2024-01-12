package com.example.shoppingMall.repository;

import com.example.shoppingMall.entity.Member;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {

    Long save(Member member);

}
