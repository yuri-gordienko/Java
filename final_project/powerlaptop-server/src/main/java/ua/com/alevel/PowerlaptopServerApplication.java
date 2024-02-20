package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.scheduling.annotation.EnableScheduling;
import ua.com.alevel.config.security.AuthenticationService;
import ua.com.alevel.config.security.RegisterRequest;
import ua.com.alevel.cron.SyncSupplierService;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.product.ProductVariantRepository;
import ua.com.alevel.persistence.sql.repository.user.AdminRepository;
import ua.com.alevel.persistence.sql.repository.user.PersonalRepository;
import ua.com.alevel.persistence.sql.type.RoleType;
import ua.com.alevel.service.csv.ExportCSVService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@EnableScheduling
@SpringBootApplication
public class PowerlaptopServerApplication {

    @Autowired
    private AuthenticationService service;

    @Autowired
    private ExportCSVService exportCSVService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private SyncSupplierService syncSupplierService;

    public static void main(String[] args) {
        SpringApplication.run(PowerlaptopServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

        String personalName = "personal101@mail.com";
//        if (!personalRepository.existsByUsername(personalName)) {
            var personal = RegisterRequest.builder()
                    .username(personalName)
                    .password("12345678")
                    .roleType(RoleType.PERSONAL)
                    .build();
            System.out.println("Personal token: " + service.register(personal));
//        }

        String adminName = "admin@mail.com";
        if (!adminRepository.existsByUsername(adminName)) {
            var admin = RegisterRequest.builder()
                    .username(adminName)
                    .password("12345678")
                    .roleType(RoleType.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());
        }
//        exportCSVService.export();

//        syncSupplierService.sync();
    }
}
