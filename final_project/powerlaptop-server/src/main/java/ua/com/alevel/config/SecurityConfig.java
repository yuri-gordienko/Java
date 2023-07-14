package ua.com.alevel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ua.com.alevel.config.security.AuthTokenFilter;
import ua.com.alevel.config.security.HandlerAccessDeniedHandler;
import ua.com.alevel.config.security.HandlerAuthenticationEntryPoint;

@Configuration // указываем что это файл конфигурации
// Спринг стартует приложение - сразу ищет Конфигурейшн классы
@EnableWebSecurity  // указываем что будет использоваться наша конфигурация секюрити а не коробочная, т.е.
// не дефолтные установки (дефолтные пароли и логины, которые генерирует Спрингсекюрити на время при старте),
// а какие мы пропишем (логины пользователей, пароли)
public class SecurityConfig {

    private static final String API = "/api";   // все запросы должны начинаться на /api
    private static final String[] WHITE_LIST_API = new String[] {
            API + "/account/authenticate",  // это логин, сюда перебрасывают контроллеры
            API + "/account/register",  // это регистрация, сюда перебрасывают контроллеры
            API + "/home",
            API + "/products/**"    // все, которые идут после продактс (plp, pdp, ....)
    };

    // таким образом этому классу SecurityConfig объясняем каким Юзердеилсервисом пользоваться (нашим, не коробочным)
    private final UserDetailsService userDetailsService;
    private final AuthTokenFilter authTokenFilter;

    public SecurityConfig(UserDetailsService userDetailsService, AuthTokenFilter authTokenFilter) {
        this.userDetailsService = userDetailsService;
        this.authTokenFilter = authTokenFilter;
    }

    @Bean // (1)
    // хранить пароли в чистом виде нельзя, не имея в виду хакеров - по Закону государства (GDPG)
    // через SHA256 (ассимитричное шифрование в одну сторону длиннейшая кракозябра) тоже плохо, т.к. через специальную
    // библиотеку на мощнейших сервер станциях хакеры НЕ дешифруют, а подбирают такой же как в БД методом сравнения
    // у Спринга свой BCryptPasswordEncoder - он каждый раз в БД генерирует новый пароль одному и тому же юзеру, поэтому
    // подобрать его методом сравнения не получится
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // (2)
    // говорим Спрингу, дай коробочного АМ в виде бина, чтоб мы могли его настроить под себя
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean // (3)
    // объясняем АМ каким юзердетеилс сервис пользоваться
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(); // Провайдер верифицирует юзердетеился
        // Провайдер проверяет соответствие пароль юзердетейлсервиса с паролем, который прилетает с http запроса через Бикриптпасвордэнкодер
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);    // указываем, что нужно нашим пользоваться
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); // каким пасвордэнкодером пользоваться
        return daoAuthenticationProvider;
    }

    @Bean // (4)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf().disable()   // отключили, т.к.csrf атаки были при SSR

                // Add token filter - будет работать перехватчик чтоб из кракозябры сделать объект
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider())

                // Set unauthorized requests exception handler
                .exceptionHandling()
                .authenticationEntryPoint(new HandlerAuthenticationEntryPoint())
                .accessDeniedHandler(new HandlerAccessDeniedHandler())
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                // Set permissions on endpoints
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST_API).permitAll()    // открытый доступ на адреса WHITE_LIST_API
                // запрос OPTIONS (может вернуть запрос сразу или через время, в зависимости от загруженности сервака) тоже открыт
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers(       // дополнительные ресурсы, которые сможем открыть
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/webjars/**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ROLE_ADMIN") // такое начало адреса - открыто только для админов
                .requestMatchers("/api/**").authenticated();
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(WHITE_LIST_API).permitAll()
//                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                        .requestMatchers(
//                                "/configuration/ui",
//                                "/swagger-resources/**",
//                                "/configuration/security",
//                                "/webjars/**").permitAll()
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/api/**").authenticated());
        // @formatter:on
        return http.build();
    }
}
