package fit.hutech.phanthithanhtuyen.BT6.config;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@AllArgsConstructor
public class SpringSecurityConfig {

    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                                authorize
                                        .requestMatchers("/").permitAll()
                                        .requestMatchers("/sinhvien/view").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                                        .requestMatchers("/sinhvien/addnew").hasAuthority("ROLE_ADMIN")
                                        .requestMatchers("/sinhvien/save").hasAuthority("ROLE_ADMIN")
                                        .requestMatchers("sinhvien/edit").hasAuthority("ROLE_ADMIN")
                                        .requestMatchers("sinhvien/del").hasAuthority("ROLE_ADMIN")
                                        /*---------------*/
                                        .requestMatchers("/khoa/view").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                                        .requestMatchers("/khoa/addnew").hasAuthority("ROLE_ADMIN")
                                        .requestMatchers("/khoa/save").hasAuthority("ROLE_ADMIN")
                                        .requestMatchers("khoa/edit").hasAuthority("ROLE_ADMIN")
                                        .requestMatchers("khoa/del").hasAuthority("ROLE_ADMIN")

                                        .anyRequest().authenticated()

                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/sinhvien/view ")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}