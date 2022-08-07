package com.github.api.parkingcontrol.backend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigV2 {

    final String URL_CADASTRO_USUARIO = "/v1/usuario/cadastrar-usuario";
    final String URL_RECUPERACAO_DE_SENHA = "/v1/usuario/recuperar-senha";
    final String URL_CONFIRMAR_EMAIL = "/email/confirmarEmail/**";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
//                .httpBasic()
//                .and()
//                .csrf().disable()
//                .authorizeRequests().anyRequest().permitAll();
                .httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(URL_CADASTRO_USUARIO).hasAuthority("ROLE_ADMINISTRADOR")
                .antMatchers(URL_RECUPERACAO_DE_SENHA).permitAll()
                .antMatchers(URL_CONFIRMAR_EMAIL).permitAll()
                .antMatchers("/**/swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**/swagger-resources/**",
                        "/**/webjars/springfox-swagger-ui/**",
                        "/**/v2/api-docs/**").permitAll()
                .anyRequest().hasAnyAuthority("ROLE_ADMINISTRADOR", "ROLE_FUNCIONARIO");

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
