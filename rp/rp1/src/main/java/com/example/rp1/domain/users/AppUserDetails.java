package com.example.rp1.domain.users;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserDetails implements UserDetails {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    // ユーザー状態のチェックで利用する
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Integer tenantId;

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    // アカウントの有効期限チェック
    @Override
    public boolean isAccountNonExpired() {
        // 常に有効
        return true;
    }

    // アカウントロックチェック
    @Override
    public boolean isAccountNonLocked() {
        // 常に無効
        return true;
    }

    // パスワード有効期限チェック
    @Override
    public boolean isCredentialsNonExpired() {
        // 常に無効
        return true;
    }

    // アカウントの有効・無効チェック
    @Override
    public boolean isEnabled() {
        // 常に有効
        return true;
    }

}
