package yugo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegramBotCatHacker {

    public static void main(String[] args) throws TelegramApiException {

        SpringApplication.run(TelegramBotCatHacker.class, args);
        System.out.println("Hello, I'm telegram-bot cat-hacker!");

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new CatHackerBot());
    }
}



