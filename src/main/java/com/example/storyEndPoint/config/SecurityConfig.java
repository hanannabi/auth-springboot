package com.example.storyEndPoint.config;

import com.example.storyEndPoint.enums.Permissions;
import com.example.storyEndPoint.filter.JwtAuthFilter;
import com.example.storyEndPoint.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                csrf(csrf -> csrf.disable()).
                authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home/authenticate").permitAll()
                        .requestMatchers("/user/register").hasAuthority(Permissions.READ_NOTE.name())
                        .requestMatchers("/user/admin/create").hasAuthority(Permissions.ADD_NOTE.name())
                        .requestMatchers("/add/program").hasAuthority(Permissions.READ_NOTE.name())
                        .requestMatchers("/programs/*/notes/add").hasAuthority(Permissions.ADD_NOTE.name())
                        .requestMatchers("/programs/*/notes").permitAll()
//                        .requestMatchers("/user/admin/create")
//                        .requestMatchers("/user/admin/create").authenticated()
                        .anyRequest().authenticated());
//        http.httpBasic(Customizer.withDefaults());
http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }
}
