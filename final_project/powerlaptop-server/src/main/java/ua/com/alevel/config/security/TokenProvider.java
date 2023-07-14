package ua.com.alevel.config.security;

import io.jsonwebtoken.Claims;  // библиотека для шифрования
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import ua.com.alevel.persistence.sql.entity.user.User;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TokenProvider {    // класс генерации ауинтиф токина

    @Value("${powerlaptop.security.secret}")    // @Value берет значения из application.properties, чтоб не писать длинный пароль
    private String secret;                  // а эти кракозыбры, которые в пропертях - рандомные, на основании их и генерируется пароль
                                            // т.е. из тех символов будет состоять новый пароль

    @Value("${powerlaptop.security.jti}")   // @Value отрабатыввает после того как отработает дефолт конструктор
    private String jti;

    private static final String USER_NAME = "userName";
    private static final String JTI = "jti";
    private static final String AUT = "aut";

    private Key hmacKey;    // сетает дефолт конструктор

    // по дефолту переменные инициализирует дефол конструкор и присваевает значения налл для ссылок, или 0 или fels для примитивов
    // если есть конструктор, присваиваются значения филдам, потом отрабатывают методы
    @PostConstruct  // ставим, для отработки метода после отработки конструктора
    public void init() {
        hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), // генерируем пароль
                SignatureAlgorithm.HS256.getJcaName());
    }

    public boolean validateToken(String authToken) {    // забрасыаем токин из поля ауторизайшн
        try {
            Optional<Claims> optionalClaims = extractClaims(authToken);
            if (optionalClaims.isEmpty()) {
                return false;
            }
            Claims claims = optionalClaims.get();   // требование заявка, некая мапа, какие параметры нужно передать
            String jtiClaims = claims.get(JTI, String.class);
            return jti.equals(jtiClaims);
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<String> extractUsername(String token) {
        try {
            Optional<Claims> optionalClaims = extractClaims(token);
            if (optionalClaims.isEmpty()) {
                return Optional.empty();
            }
            Claims claims = optionalClaims.get();
            String email = claims.get(USER_NAME, String.class);
            return Optional.of(email);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public String generateToken(Authentication authentication) {    // генерируем токин
        Instant now = Instant.now();    // берем текущее время
        String authorities = authentication.getAuthorities()// берем его Authorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));  // объединяем все
        User userPrincipal = (User) authentication.getPrincipal();  // на юзере
        return Jwts.builder()   // сторим Jwts токин
                .claim(AUT, authorities) // пошли задавать разные параметры
                .claim(USER_NAME, userPrincipal.getUsername())
                .setSubject(userPrincipal.getUsername())
                .setId(jti)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(24L, ChronoUnit.HOURS)))  // время жизни токена 24 часа
                .signWith(hmacKey)  // алгоритм шифрования
                .compact(); // вернется нам строка внутри которой будет жить зашифрованный объъект
    }

    private Optional<Claims> extractClaims(String token) {
        try {
            // jwt json web tokin, объект типа джейсона зашифрованный в строку в кракозябру
            // кракозябру отправляем на фронт, а когда тот присылает нам ее обратно мы ее дешифруем в джава объект
            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(token);
            return Optional.of(jwt.getBody());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
