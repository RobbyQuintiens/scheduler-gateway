package com.example.schedulergateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configureResourceServer(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/actuator/health/**").permitAll();
                    request.requestMatchers("/users")
                            .hasAnyAuthority("USER", "ADMIN");
                });
        return http.build();
    }
}
