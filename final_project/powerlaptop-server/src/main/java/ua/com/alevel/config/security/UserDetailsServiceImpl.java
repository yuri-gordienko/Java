package ua.com.alevel.config.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.sql.entity.user.User;
import ua.com.alevel.persistence.sql.repository.user.UserRepository;

import java.util.Optional;

@Service(value = "userService") // "userService" по этому имени будем использовать UserDetailsServiceImpl
public class UserDetailsServiceImpl implements UserDetailsService { // будет возращать Userа, который в Бейсэнтити

    private final UserRepository<User> userRepository; // работает с каким-то Юзером (персонал или админ мы не знаем)
    private final AccountStatusUserDetailsChecker detailsChecker =
            new AccountStatusUserDetailsChecker();

    public UserDetailsServiceImpl(UserRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    // создаем юзер детеилса в бзер детеилс сервис
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // берем только по логину loadUserByUsername, т.к. Юзер детейлз сервис пароля не знает
        Optional<User> user = getUserByUsername(username); // достаем Опшинал юзера
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password."); // если пустой бросаем экзепшн
        }
        detailsChecker.check(user.get());   // если чек не прошол, то будет экзепшн
        return user.get();  // если прошол, то возвращаем юзера
    }

    private Optional<User> getUserByUsername(String usernameValue) {
        String username = StringUtils.trimToNull(usernameValue); // обрезаем все пробелы, проверяем что не налл
        if (StringUtils.isBlank(username)) {
            return Optional.empty();
        }
        return userRepository.findActiveByUsername(username);
    }
}
