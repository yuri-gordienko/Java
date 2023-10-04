package yugo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotRegister {      // реєстрація на сервері та активація сесії

    private final VacanciesBot vacanciesBot; // екземпляр класу, до якого звертаємось, зберігає Токен

    // конструктор, можно без нього через @AllArgsConstructor
    public BotRegister(VacanciesBot vacanciesBot) { this.vacanciesBot = vacanciesBot; }

    @PostConstruct
    public void init() throws TelegramApiException { // метод запуску реєстрації
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class); // створили API з'єднання, та отримали дефолтну сесію
        telegramBotsApi.registerBot(vacanciesBot); // кладемо наш Токен в статичний метод реєстрації
    }
}
