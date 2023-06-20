package ua.com.alevel.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component  // между этой аннотацией и аннот Сервис разницы никакой (так исторически сложилась), это все Бин классы
public class AuthTokenFilter extends OncePerRequestFilter { // фильтрует футТокины которые лежат в ауторизайшн заголовке
// это перехватчик, перед тем как запрос дойдет до метода
    private final TokenProvider tokenProvider;
    private final UserDetailsService userService;

    public AuthTokenFilter(TokenProvider tokenProvider, UserDetailsService userService) {
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, // перехватываем и говорим фронту блок, то-то мне не нравиться и контроллер не отработает
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        Optional<String> jwt = resolveHeaderToken(request); // вытягивает поле из авторизейшн метода, и сравнивает на валидность
        // jwt json web tokin, объект типа джейсона зашифрованный в строку в кракозябру
        // кракозябру отправляем на фронт, а когда тот присылает нам ее обратно мы ее дешифруем в джава объект
        if (jwt.isPresent() && tokenProvider.validateToken(jwt.get())) {
            Optional<String> optionalUsername = tokenProvider.extractUsername(jwt.get());
            if (optionalUsername.isEmpty()) {
                throw new RuntimeException("invalid token");
            }
            String username = optionalUsername.get();
            if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userService.loadUserByUsername(username); // если все хорошо достаем юзера детейлз
                // создаем специальный класс UsernamePasswordAuthenticationToken(userDetails и класть его в  SecurityContextHolder
                var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private Optional<String> resolveHeaderToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        return StringUtils
                .isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")   // если токин есть (не пустой), начинается на Бирер
                ? Optional.of(bearerToken.substring(7))
                : Optional.empty(); // возвращаем опшенал пустой
    }
}
