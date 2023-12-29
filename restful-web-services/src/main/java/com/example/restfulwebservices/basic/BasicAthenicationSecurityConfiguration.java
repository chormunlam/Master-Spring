package com.example.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAthenicationSecurityConfiguration {
    //filter chain
    //authenicate all requests
    //basic authenication
    //disabling csrf
    //stateless rest api

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //reponse to preflight request dones pass access control check, //option permitted
        //basic auth
        return
                http
                        .authorizeHttpRequests(
                auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
                .csrf().disable()
                .build();
    }
}

