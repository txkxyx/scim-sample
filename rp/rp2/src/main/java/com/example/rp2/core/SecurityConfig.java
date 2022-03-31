package com.example.rp2.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// セキュリティ設定クラス
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // パスワードエンコーダーのBean定義
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    // @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/signup").permitAll() // アクセス許可
                .anyRequest().authenticated(); // それ以外は直リンク禁止

        http
                .formLogin()
                .loginProcessingUrl("/login") // ログイン処理のパス
                .loginPage("/login") // ログインページの指定
                .failureUrl("/login?error") // ログイン失敗時の遷移先
                .usernameParameter("userId") // ログインリクエスト時のログインIDのパラメーター
                .passwordParameter("password") // ログインリクエスト時のパスワードのパラメーター
                .defaultSuccessUrl("/home", true); // ログイン後の遷移先

        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // ログアウト処理のパス
                .logoutUrl("/logout") // ログアウト時のアクセスURL
                .logoutSuccessUrl("/login"); // ログアウト後の遷移先
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
