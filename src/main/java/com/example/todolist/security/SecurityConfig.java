package com.example.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

/**
 * SecurityConfig is a configuration class that sets up the security features of the application.
 * It enables web security, configures user details service, password encoding, and defines the security filter chain.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures a UserDetailsService using a JDBC-based user store.
     *
     * @param dataSource The DataSource used to connect to the database.
     * @return A UserDetailsService implementation that retrieves user details from the database.
     */
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    /**
     * Provides a BCryptPasswordEncoder bean for encoding passwords.
     *
     * @return A BCryptPasswordEncoder instance.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the security filter chain, defining how requests are secured and authenticated.
     * It disables CSRF protection, sets up form-based login, and configures access rules for different URLs.
     *
     * @param http The HttpSecurity object used to configure security settings.
     * @param userDetailsService The UserDetailsService used for authentication.
     * @return A SecurityFilterChain that defines the security configuration.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disables CSRF protection
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/register", "/login", "/error", "/h2-console/**", "/css/**", "/js/**", "/images/**").permitAll()   // Allows access to certain URLs without authentication
                        .anyRequest().authenticated()   // Requires authentication for all other requests
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/note/list", true)
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));  // Disables X-Frame-Options to allow H2 console

        return http.build();
    }
}
