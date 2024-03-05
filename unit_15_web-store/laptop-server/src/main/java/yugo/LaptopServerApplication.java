package yugo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaptopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaptopServerApplication.class, args);
        System.out.println("Laptop-server is running");
    }
}