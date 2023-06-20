package ua.com.alevel;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.com.alevel.service.ImportProductToCsvService;

@SpringBootApplication
@AllArgsConstructor
public class PowerlaptopSupplierApplication {   // наш виртуальный поставщик ноутбуков

    private final ImportProductToCsvService service;

    public static void main(String[] args) {
        SpringApplication.run(PowerlaptopSupplierApplication.class, args);  // запуск Спринга
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
//        service.importCsv();  // импортируем (создаем базу а основании БД продавца)
    }
}