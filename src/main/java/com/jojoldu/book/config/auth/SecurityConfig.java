package com.jojoldu.book.config.auth;

import com.jojoldu.book.web.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOauth2UserService customOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .headers().frameOptions().disable()
               .and()
               .authorizeRequests()
               .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**","/profile").permitAll()
               .antMatchers("/api/v1/**").hasRole(Role.USER.name())
               .anyRequest().authenticated()
               .and()
               .logout()
               .logoutSuccessUrl("/")
               .and()
               .oauth2Login()
               .userInfoEndpoint()
               .userService(customOauth2UserService);
    }
}
