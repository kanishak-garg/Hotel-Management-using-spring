package com.personal.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HotelSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return http.build();
    }

    @Bean
    public UserDetailsService users(){
        UserDetails user1 = User.builder()
                .username("tony")
                .password(passwordEncoder().encode("password"))
                .roles("NORMAL")
                .build();

        UserDetails user2 = User.builder()
                .username("kanishak")
                .password(passwordEncoder().encode("happy"))
                .roles("NORMAL")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}









