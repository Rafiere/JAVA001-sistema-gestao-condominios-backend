package com.github.api.parkingcontrol.backend.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Esse é o modo antigo de realizar a configuração do Spring Security.
 */

//@Configuration
//@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        final String URL_RECUPERACAO_DE_SENHA = "NULL";

        http
                .httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/usuario/cadastrar-usuario").hasRole("ADMINISTRADOR")
                .antMatchers("/**/swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**/swagger-resources/**",
                        "/**/webjars/springfox-swagger-ui/**",
                        "/**/v2/api-docs/**").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceImpl) //A autenticação será realizada através desse serviço.
                .passwordEncoder(passwordEncoder());
    }

//    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
}
