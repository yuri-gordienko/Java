//package ua.com.alevel.config.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import lombok.AllArgsConstructor;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@Component
//@AllArgsConstructor
//public class AuthTokenFilter extends OncePerRequestFilter {
//
//    private final TokenProvider tokenProvider;
//    private final UserDetailsService userService;
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain) throws ServletException, IOException {
//        Optional<String> jwt = resolveHeaderToken(request);
//        if (jwt.isPresent() && tokenProvider.validateToken(jwt.get())) {
//            Optional<String> optionalUsername = tokenProvider.extractUsername(jwt.get());
//            if (optionalUsername.isEmpty()) {
//                throw new RuntimeException("invalid token");
//            }
//            String username = optionalUsername.get();
//            if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = userService.loadUserByUsername(username);
//                var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private Optional<String> resolveHeaderToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        return StringUtils
//                .isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")
//                ? Optional.of(bearerToken.substring(7))
//                : Optional.empty();
//    }
//}
