package yugo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatHackerBotApp {

    public static void main(String[] args) {

        SpringApplication.run(CatHackerBotApp.class, args);
        System.out.println("Hello, cat!");
    }
}