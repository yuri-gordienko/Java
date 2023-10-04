package yugo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class EnglishGrammarBot extends TelegramLongPollingBot {

    public EnglishGrammarBot() {
        super("6563660262:AAGvacUwaZelFqGBaOagMZW7vAAQaj6xOjw");
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "English grammar";
    }
}
