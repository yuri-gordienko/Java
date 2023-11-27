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
//        if (update.hasMessage()) {  // перевіряємо чи є взагалі напечатана смс, але для кнопки перевіряє інший метод
//            if (update.getMessage().getText().equals("/start")) {
//                SendMessage message = createMessage(chatId, "*Hello, I'm telegram-bot cat-hacker!*");
//                sendApiMethodAsync(message);
//            }
//        }
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) { // equals обов'язково точно "/start"
            SendMessage message = createMessage(chatId, "*Привіт, я кіт-хакер!*");
            sendApiMethodAsync(message);
        }
        if (update.hasMessage() && update.getMessage().getText().toLowerCase().contains("привіт")) { // contains має включати
            SendMessage message = createMessage(chatId, "Як тебе звуть?");
            sendApiMethodAsync(message);
        }
        if (update.hasMessage() && update.getMessage().getText().toLowerCase().contains("мене звуть")) {
            SendMessage message = createMessage(chatId, "Радий знайомству, я — *Кіт*");
            sendApiMethodAsync(message);
        }
    }
}
