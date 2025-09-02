package com.shashu.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.shashu.springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            	 .requestMatchers("/registration**").permitAll()
       			 .requestMatchers("/js/**").permitAll()
       			 .requestMatchers("/css/**").permitAll()
       			 .requestMatchers("/img/**").permitAll()
       			 .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true) // redirect after login
                .permitAll()
            )
            .logout(logout -> logout
            		.logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true)       // clear session
                    .deleteCookies("JSESSIONID")  
            		.permitAll());

        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
           .userDetailsService(userService)
           .passwordEncoder(passwordEncoder());
    }
}
