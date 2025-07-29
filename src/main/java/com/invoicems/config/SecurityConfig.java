package com.invoicems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .requestMatchers("/signup", "/verify","/sendOtp", "/login", "/items/**",
                             "/verifyOtp", "/forgotPassword", "/resetPassword", "/sendForgotOtp",
                             "/vendors/**", "/invoices/**").permitAll()  
            .anyRequest().authenticated()  
            .and()
            .httpBasic();  // Enable HTTP Basic Authentication

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Allow CORS for all paths
                        .allowedOrigins("http://localhost:3000")  // Specify your React frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed HTTP methods
                        .allowedHeaders("*")  // Allow all headers
                        .allowCredentials(true)  // Allow credentials (cookies, authorization headers)
                        .maxAge(3600);  // Max age for pre-flight requests in seconds
            }
        };
    }
}