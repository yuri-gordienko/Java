package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import ua.com.alevel.persistence.sql.entity.user.Admin;
//import ua.com.alevel.persistence.sql.repository.user.AdminRepository;
import ua.com.alevel.persistence.sql.type.RoleType;

@SpringBootApplication
public class TripServerApplication {

//    @Autowired
//    private AuthenticationService service;

//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Autowired
//    private AdminRepository adminRepository;



    public static void main(String[] args) {

        SpringApplication.run(TripServerApplication.class, args);
    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void run() {
//
//        String adminName = "admin@mail.com";
//        if (!adminRepository.existsByUsername(adminName)) {
//            Admin admin = new Admin();
//            admin.setUsername(adminName);
//            admin.setPassword(encoder.encode("12345678"));
//            adminRepository.save(admin);
//        }

//        String adminName = "admin@mail.com";
//        if (!adminRepository.existsByUsername(adminName)) {
//            var admin = RegisterRequest.builder()
//                    .username(adminName)
//                    .password("12345678")
//                    .roleType(RoleType.ADMIN)
//                    .build();
//            System.out.println("Admin token: " + service.register(admin).getAccessToken());
//        }

//    }
}