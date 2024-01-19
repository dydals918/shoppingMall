package com.example.shoppingMall.securityConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityMember implements UserDetails{

    private Long id;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberGender;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return memberPw;
    }

    @Override
    public String getUsername() {
        return memberId;
    }

    /*
        계정 만료 여부
        true : 만료 x
        false : 만료 o
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*
        계정 잠김 여부
        true : 잠김 x
        false : 잠김 o
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*
        비밀번호 만료 여부
        true : 만료 x
        false : 만료 o
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
        사용자 활성화 여부
        ture : 활성화
        false : 비활성화
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public SecurityMember (Long id, String memberId, String memberPw, String memberName, String memberGender) {
        this.id = id;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberGender = memberGender;
    }
}
