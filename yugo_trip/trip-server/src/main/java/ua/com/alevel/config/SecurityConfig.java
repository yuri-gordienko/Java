//package ua.com.alevel.config;
//
//import lombok.AllArgsConstructor;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import ua.com.alevel.config.security.AuthTokenFilter;
//import ua.com.alevel.config.security.HandlerAccessDeniedHandler;
//import ua.com.alevel.config.security.HandlerAuthenticationEntryPoint;
//
//@Configuration
//@AllArgsConstructor
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private static final String API = "/api";
//    private static final String[] WHITE_LIST_API = new String[] {
//            API + "/account/authenticate",
//            API + "/account/register",
//            API + "/home",
//            API + "/tours/**"
//    };
//
//    private final UserDetailsService userDetailsService;
//    private final AuthTokenFilter authTokenFilter;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//
//
//                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
//                .authenticationProvider(authenticationProvider())
//
//                .exceptionHandling()
//                .authenticationEntryPoint(new HandlerAuthenticationEntryPoint())
//                .accessDeniedHandler(new HandlerAccessDeniedHandler())
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//
//                .authorizeHttpRequests()
//                .requestMatchers(WHITE_LIST_API).permitAll()
//                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .requestMatchers(
//                        "/configuration/ui",
//                        "/swagger-resources/**",
//                        "/configuration/security",
//                        "/webjars/**").permitAll()
//                .requestMatchers("/api/admin/**").hasRole("ROLE_ADMIN")
//                .requestMatchers("/api/**").authenticated();
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers(WHITE_LIST_API).permitAll()
////                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
////                        .requestMatchers(
////                                "/configuration/ui",
////                                "/swagger-resources/**",
////                                "/configuration/security",
////                                "/webjars/**").permitAll()
////                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
////                        .requestMatchers("/api/**").authenticated());
//        // @formatter:on
//        return http.build();
//    }
//}
