package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.scheduling.annotation.EnableScheduling;
import ua.com.alevel.config.security.AuthenticationService;
import ua.com.alevel.config.security.RegisterRequest;
import ua.com.alevel.persistence.sql.repository.user.AdminRepository;
import ua.com.alevel.persistence.sql.repository.user.PersonalRepository;
import ua.com.alevel.persistence.sql.type.RoleType;

@EnableScheduling
@SpringBootApplication
public class TripServerApplication {

    @Autowired
    private AuthenticationService service;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PersonalRepository personalRepository;


    public static void main(String[] args) {

        SpringApplication.run(TripServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

        String personalName1 = "user1@mail.com";
//        if (!personalRepository.existsByUsername(personalName)) {
        var personal1 = RegisterRequest.builder()
                .username(personalName1)
                .password("11111")
                .roleType(RoleType.PERSONAL)
                .build();
        System.out.println("Personal token: " + service.register(personal1));
//        }
        String personalName2 = "user2@mail.com";
//        if (!personalRepository.existsByUsername(personalName)) {
        var personal2 = RegisterRequest.builder()
                .username(personalName2)
                .password("22222")
                .roleType(RoleType.PERSONAL)
                .build();
        System.out.println("Personal token: " + service.register(personal2));

        String adminName = "admin@mail.com";
        if (!adminRepository.existsByUsername(adminName)) {
            var admin = RegisterRequest.builder()
                    .username(adminName)
                    .password("12345678")
                    .roleType(RoleType.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());
        }
    }
}