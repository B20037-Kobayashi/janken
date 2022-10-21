package oit.is.z0340.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class JankenAuthConfiguration {
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserBuilder users = User.builder();
    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$FEwKdp7.S4WNHIL7i4h0z.smN.uQ50UNe5I7.BlSOJAkVoeX3/O6a")
        .roles("USER")
        .build();

    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$FEwKdp7.S4WNHIL7i4h0z.smN.uQ50UNe5I7.BlSOJAkVoeX3/O6a")
        .roles("USER")
        .build();

    UserDetails user3 = users
        .username("ほんだ")
        .password("$2y$10$FEwKdp7.S4WNHIL7i4h0z.smN.uQ50UNe5I7.BlSOJAkVoeX3/O6a")
        .roles("USER")
        .build();

    UserDetails admin = users
        .username("admin")
        .password("$2y$10$FEwKdp7.S4WNHIL7i4h0z.smN.uQ50UNe5I7.BlSOJAkVoeX3/O6a")
        .roles("ADMIN")
        .build();

    return new InMemoryUserDetailsManager(user1, user2, user3, admin);
  }

  @Bean
  public SecurityFilterChain filterNhain(HttpSecurity http) throws Exception {
    http.formLogin();

    http.authorizeHttpRequests()
        .mvcMatchers("/janken/**").authenticated();

    http.logout().logoutSuccessUrl("/");

    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
