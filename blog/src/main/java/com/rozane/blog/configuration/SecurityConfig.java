//package com.rozane.blog.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // Desative o CSRF apenas se necessário; use com cautela
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/api/posts/**").hasRole("ADMIN") // Apenas usuários com a role ADMIN podem acessar essas rotas
//                        .anyRequest().authenticated() // Outras rotas precisam estar autenticadas
//                )
//                .httpBasic(); // Autenticação HTTP básica
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")
//                .roles("ADMIN") // Define a role ADMIN para o usuário
//                .build();
//
//        return new InMemoryUserDetailsManager(admin); // Cria um UserDetailsService com um usuário em memória
//    }
//}
