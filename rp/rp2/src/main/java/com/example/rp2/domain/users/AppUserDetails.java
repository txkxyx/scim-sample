package com.example.rp2.domain.users;

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

    private String password;

    // ユーザー状態のチェックで利用する
    private Long id;

    private String code;
    private String firstName;

    private String firstNameKana;

    private String lastName;

    private String lastNameKana;

    private Long tenantId;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
