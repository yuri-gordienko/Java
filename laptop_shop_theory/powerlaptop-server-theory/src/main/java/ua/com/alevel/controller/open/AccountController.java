package ua.com.alevel.controller.open;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.config.security.TokenProvider;
import ua.com.alevel.data.dto.auth.LoginDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.user.RegistrationFacade;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final RegistrationFacade registrationFacade;

    public AccountController(
            AuthenticationManager authenticationManager,
            TokenProvider tokenProvider,
            RegistrationFacade registrationFacade) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.registrationFacade = registrationFacade;
    }

    @PostMapping("/authenticate")   // будет отрабатывать при запросе на аунтификацию
    public ResponseEntity<DataContainer<String>> authenticateUser(@Valid @RequestBody LoginDto loginDto) {
        String jwt = authenticateAndTokenGenerate(loginDto.username(), loginDto.password());
        return ResponseEntity.ok(new DataContainer<>(jwt));
    }

    @PostMapping("/register")   // регистрируем
    public ResponseEntity<DataContainer<String>> register(@Valid @RequestBody LoginDto dto) {
        registrationFacade.create(dto);
        String jwt = authenticateAndTokenGenerate(dto.username(), dto.password());
        return ResponseEntity.ok(new DataContainer<>(jwt));
    }

    private String authenticateAndTokenGenerate(String username, String password) {
        var authentication = authenticationManager  // отрабатывает менеджер
                .authenticate(
                        new UsernamePasswordAuthenticationToken(    // проверка
                                username,
                                password));
        SecurityContextHolder.getContext().setAuthentication(authentication); // то кладем объект в секюрити контекст
        return tokenProvider.generateToken(authentication); // и возвращаем пользователю токин
    }
}
