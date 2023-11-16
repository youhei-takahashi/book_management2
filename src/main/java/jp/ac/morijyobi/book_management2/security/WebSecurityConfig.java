package jp.ac.morijyobi.book_management2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/").permitAll()   // /という URLはログイン無しでアクセスOK
                .anyRequest().authenticated()       // それ以外のURLはログインが必要
            ).formLogin(login -> login
                .loginProcessingUrl("/login")       // ユーザID・PWの送信先URL(POST)
                .loginPage("/login")                // ログイン画面のURL(GET)
                .defaultSuccessUrl("/")             // ログイン成功時のリダイレクト先URL
                .failureUrl("/login?error")     // ログイン失敗時のリダイレクト先URL
                .permitAll()                        // ログイン画面のアクセス権限の設定(すべて許可)
            );

        return http.build();
    }
}