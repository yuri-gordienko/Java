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
import ua.com.alevel.persistence.sql.repository.user.AdminRepository;
import ua.com.alevel.persistence.sql.type.RoleType;
import ua.com.alevel.service.csv.ExportCSVService;

@EnableScheduling      // для того, чтоб БД Эластика обновлялась по определенному расписанию и закачивала инфо из SQL БД
// если деактивировать аннотацию, по идее должен отключиться эластик
@SpringBootApplication // автоконфигуратор приложения
public class PowerlaptopServerApplicationTheory {

    @Autowired
    private AuthenticationService service;

    @Autowired
    private ExportCSVService exportCSVService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SyncSupplierService syncSupplierService;

    public static void main(String[] args) {
        // передали мэйн класс для автоматического создания спринг приложения
        SpringApplication.run(PowerlaptopServerApplicationTheory.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void run() {
//        System.out.println("PowerlaptopServerApplication.run");
//
//        String password = "12345";
//        String hash = "$2a$10$2b4OLA.gCg8oLcENaIzqvOKWyb7mkFXcNjPN5OnmW8P4igAX8eY/i";
//        String hash1 = "$2a$10$2b4OLA.gCg8oLcENaIzqvOKWyb7mkFXcNjPN5OnmW8P4igAX8eY/j";
//
//        System.out.println("password = " + encoder.encode(password));
//        System.out.println("password = " + encoder.encode(password));
//        System.out.println("password = " + encoder.encode(password));
//        System.out.println("password = " + encoder.encode(password));
//
//        System.out.println();
//
//        System.out.println("valid = " + encoder.matches(password, hash));
//        System.out.println("valid = " + encoder.matches(password, hash1));

//        String adminName = "admin@mail.com";    // говорим кого пропускать в качестве админа (с какого домена обращение)
//        if (!adminRepository.existsByUsername(adminName)) {
//            Admin admin = new Admin();
//            admin.setUsername(adminName);
//            admin.setPassword(encoder.encode("12345678"));
//            adminRepository.save(admin);
//        }
        @EventListener(ApplicationReadyEvent.class)
        public void run() {
            String adminName = "admin@mail.com";    // говорим кого пропускать в качестве админа (с какого домена обращение)
            if (!adminRepository.existsByUsername(adminName)) {
                var admin = RegisterRequest.builder()
                        .username(adminName)    // сетаем пермишены админа
                        .password("12345678")
                        .roleType(RoleType.ADMIN)
                        .build();
                System.out.println("Admin token: " + service.register(admin).getAccessToken());
            }
//        exportCSVService.export();

//        syncSupplierService.sync();
        }
}
