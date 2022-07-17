package br.com.letscode.letsgoal.security;

// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@EnableWebSecurity
@Slf4j
public class ApplicationSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // se API sem estado e proteção CSRF fizer sentido, remover!
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                .antMatchers("/patrocinadores").hasRole("USER")
                .anyRequest().authenticated() 
            .and()
                .formLogin()
            .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

    //@Bean
    //public UserDetailsService userDetailsService(DataSource dataSource) {
    //    return new JdbcUserDetailsManager(dataSource);
    //}

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        //String pswd = passwordEncoder().encode("123"); // outra forma

        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2y$10$cWbRhu7hLEwE6azH1YBRzumFHoPGSTyXSRoNQYfWuC9Wc/Nz4AyZG")
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("rafa")
                .password("{bcrypt}$2y$10$cWbRhu7hLEwE6azH1YBRzumFHoPGSTyXSRoNQYfWuC9Wc/Nz4AyZG")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return createDelegatingPasswordEncoder();
    }

    // TODO refactoring
    /*
    public SecurityWebFilterChain http(ServerHttpSecurity http) throws Exception {
        DelegatingServerLogoutHandler logoutHandler = new DelegatingServerLogoutHandler(
            new WebSessionServerLogoutHandler(),
            new SecurityContextServerLogoutHandler()
        );
        http
            .authorizeExchange((exchange) -> exchange.anyExchange().authenticated())
            .logout((logout) -> logout.logoutHandler(logoutHandler));
        return http.build();
    }
    */

    public static PasswordEncoder createDelegatingPasswordEncoder() {
        String encodingId = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
        encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

}