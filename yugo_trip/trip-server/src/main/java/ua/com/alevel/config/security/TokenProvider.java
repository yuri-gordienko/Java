//package ua.com.alevel.config.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import jakarta.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import ua.com.alevel.persistence.sql.entity.user.User;
//
//import javax.crypto.spec.SecretKeySpec;
//import java.security.Key;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Base64;
//import java.util.Date;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Component
//public class TokenProvider {
//
//    @Value("${yugo_trip.security.secret}")
//    private String secret;
//
//    @Value("${yugo_trip.security.jti}")
//    private String jti;
//
//    private static final String USER_NAME = "userName";
//    private static final String JTI = "jti";
//    private static final String AUT = "aut";
//
//    private Key hmacKey;
//
//    @PostConstruct
//    public void init() {
//        hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
//                SignatureAlgorithm.HS256.getJcaName());
//    }
//
//    public boolean validateToken(String authToken) {
//        try {
//            Optional<Claims> optionalClaims = extractClaims(authToken);
//            if (optionalClaims.isEmpty()) {
//                return false;
//            }
//            Claims claims = optionalClaims.get();
//            String jtiClaims = claims.get(JTI, String.class);
//            return jti.equals(jtiClaims);
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Optional<String> extractUsername(String token) {
//        try {
//            Optional<Claims> optionalClaims = extractClaims(token);
//            if (optionalClaims.isEmpty()) {
//                return Optional.empty();
//            }
//            Claims claims = optionalClaims.get();
//            String email = claims.get(USER_NAME, String.class);
//            return Optional.of(email);
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }
//
//    public String generateToken(Authentication authentication) {
//        Instant now = Instant.now();
//        String authorities = authentication.getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//        User userPrincipal = (User) authentication.getPrincipal();
//        return Jwts.builder()
//                .claim(AUT, authorities)
//                .claim(USER_NAME, userPrincipal.getUsername())
//                .setSubject(userPrincipal.getUsername())
//                .setId(jti)
//                .setIssuedAt(Date.from(now))
//                .setExpiration(Date.from(now.plus(24L, ChronoUnit.HOURS)))
//                .signWith(hmacKey)
//                .compact();
//    }
//
//    private Optional<Claims> extractClaims(String token) {
//        try {
//            Jws<Claims> jwt = Jwts.parserBuilder()
//                    .setSigningKey(hmacKey)
//                    .build()
//                    .parseClaimsJws(token);
//            return Optional.of(jwt.getBody());
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }
//}
