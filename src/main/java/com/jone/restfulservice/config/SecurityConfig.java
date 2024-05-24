package com.jone.restfulservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
//
//    @Bean
//    UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        UserDetails newUser = User.withUsername("kwonoh")
//                .password(passwordEncoder().encode("mygod"))
//                .authorities("read")
//                .build();
//
//        userDetailsManager.createUser(newUser);
//        return userDetailsManager;
//    }
//
//    @Bean
//    BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    public WebSecurityCustomizer webSecurityCustomizer() {
////        return (web -> web.ignoring() // webflux
////                .requestMatchers(new AntPathRequestMatcher())
////    }
}
