package com.matthewblit.car_show.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(c-> c.disable())
                .cors(c-> c.configurationSource(corFilter()))
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(c -> c
                        .requestMatchers(HttpMethod.GET,"/api/v1/car/")
                        .permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/car/")
                        .hasRole("ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(ses -> ses
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(false);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password(passwordEncoder().encode("adminPass"))
////                .roles("ADMIN")
////                .build();
////        UserDetails user = User.builder()
////                .username("user")
////                .password(passwordEncoder().encode("userPass"))
////                .roles("USER")
////                .build();
////        return new InMemoryUserDetailsManager(admin, user);
//
//
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
