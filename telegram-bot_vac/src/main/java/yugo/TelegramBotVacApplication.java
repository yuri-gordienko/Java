package yugo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelegramBotVacApplication {

	public static void main(String[] args) {

		SpringApplication.run(TelegramBotVacApplication.class, args);
		System.out.println("Hello, i'm telegram-bot");
	}
}
