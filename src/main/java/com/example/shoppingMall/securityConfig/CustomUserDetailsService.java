package com.example.shoppingMall.securityConfig;

import com.example.shoppingMall.entity.Member;
import com.example.shoppingMall.enums.MemberRole;
import com.example.shoppingMall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Member byMemberId = memberRepository.findByMemberId(username);

            SecurityMember securityMember = new SecurityMember(
                    byMemberId.getId(),
                    byMemberId.getMemberId(),
                    byMemberId.getMemberPw(),
                    byMemberId.getMemberName(),
                    byMemberId.getMemberGender()
            );

            MemberRole role = byMemberId.getRole();
            securityMember.setAuthorities(Collections.singleton(new SimpleGrantedAuthority(role.getValue())));

            return securityMember;
        } catch (Exception e){
            throw new UsernameNotFoundException("user not found");
        }

    }

}
