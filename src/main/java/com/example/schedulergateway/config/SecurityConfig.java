package com.example.schedulergateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityFilter(ServerHttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/actuator/health/**").permitAll()
                        .pathMatchers("/scheduler/admin/info").hasAuthority("SCOPE_admin")
                        .pathMatchers("/test/gateway").permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer((oauth) -> oauth
                        .jwt(Customizer.withDefaults()))
                .build();
    }
}
