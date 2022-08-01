package com.github.api.parkingcontrol.backend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigV2 {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        final String URL_RECUPERACAO_DE_SENHA = "NULL"; //TODO: Inserir URL para a recuperação de senha.

        http
            .httpBasic()
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/**/swagger-ui", //Não está funcionando.
                    URL_RECUPERACAO_DE_SENHA)
            .permitAll()
            .antMatchers("/usuario/cadastrar-usuario").hasRole("ADMIN");
//            .anyRequest()
//            .authenticated();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
}
