package yugo;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static yugo.TelegramBotUtils.createMessage;
import static yugo.TelegramBotUtils.getChatId;

public class CatHackerBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "yugo_cat_hacker_bot";
    }

    @Override
    public String getBotToken() {
        return "6988443969:AAHfY-AxRF6hhQuKd-NHDVD1Rjps6hsgbn0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);
        SendMessage message = createMessage(chatId, "Hello, I'm telegram-bot cat-hacker!");
        sendApiMethodAsync(message);
    }
}
