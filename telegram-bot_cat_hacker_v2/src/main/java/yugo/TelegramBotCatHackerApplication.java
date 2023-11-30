package yugo;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import yugo.service.CatHackerBotService;

public class TelegramBotCatHackerApplication {

    public static void main(String[] args) throws TelegramApiException {

        CatHackerBotService catHackerBotService = new CatHackerBotService();
        catHackerBotService.run();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new CatHackerBotService());
    }
}



