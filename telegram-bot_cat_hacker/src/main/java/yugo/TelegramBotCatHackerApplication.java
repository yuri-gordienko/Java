package yugo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import yugo.service.CatHackerBotService;
import yugo.service.CatHackerBotServiceRefactoringCode;

@SpringBootApplication
public class TelegramBotCatHackerApplication {

    public static void main(String[] args) throws TelegramApiException {

        SpringApplication.run(TelegramBotCatHackerApplication.class, args);
        System.out.println("Hello, I'm telegram-bot cat-hacker!");

//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class); // реєстрація на сервері і сесія
//        telegramBotsApi.registerBot(new CatHackerBot());

//        new TelegramBotsApi(DefaultBotSession.class).registerBot(new CatHackerBotService());
        new TelegramBotsApi(DefaultBotSession.class).registerBot(new CatHackerBotServiceRefactoringCode());
    }
}



