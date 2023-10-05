package yugo;

import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnglishGrammarBot extends TelegramLongPollingBot {

    public EnglishGrammarBot() {
        super("6563660262:AAGvacUwaZelFqGBaOagMZW7vAAQaj6xOjw");
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.getMessage() != null) {
                runStartMenu(update);
            }
            if (update.getCallbackQuery() != null) {
                String callbackData = update.getCallbackQuery().getData();

                if ("ShowPresentTenses".equals(callbackData)) {
                    showPresentTenses(update);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't send message to user!", e);
        }
    }

    private void showPresentTenses(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Specifically of tense:");
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setReplyMarkup(getPresentTensesMenu());
        execute(sendMessage);
    }

    private ReplyKeyboard getPresentTensesMenu() {
        List<InlineKeyboardButton> subMenuButtons = new ArrayList<>();

        InlineKeyboardButton simple = new InlineKeyboardButton();
        simple.setText("Simple");
        simple.setCallbackData("show_present_simple");
        subMenuButtons.add(simple);

        InlineKeyboardButton continuous = new InlineKeyboardButton();
        continuous.setText("Continuous");
        continuous.setCallbackData("show_present_continuous");
        subMenuButtons.add(continuous);

        InlineKeyboardButton perfect = new InlineKeyboardButton();
        perfect.setText("Perfect");
        perfect.setCallbackData("show_present_perfect");
        subMenuButtons.add(perfect);

        InlineKeyboardButton pf = new InlineKeyboardButton();
        pf.setText("Perfect Continuous");
        pf.setCallbackData("show_present_perf_cont");
        subMenuButtons.add(pf);

        InlineKeyboardMarkup presentMenu = new InlineKeyboardMarkup();
        presentMenu.setKeyboard(List.of(subMenuButtons));

        return presentMenu;
    }

    private void runStartMenu(Update update) {
        String msgFromUser = update.getMessage().getText();
        System.out.println(msgFromUser);

        SendMessage smgToUser = new SendMessage();
        smgToUser.setChatId(update.getMessage().getChatId());
        smgToUser.setText("Welcome to English grammar study application! \n" +
                "Here you can read or learn english language's tenses");
        smgToUser.setReplyMarkup(getStartMenu());
        try {
            execute(smgToUser);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private ReplyKeyboard getStartMenu() {
        List<InlineKeyboardButton> startMenuButtons = new ArrayList<>();

        InlineKeyboardButton present = new InlineKeyboardButton();
        present.setText("Present tenses");
        present.setCallbackData("ShowPresentTenses");
        startMenuButtons.add(present);

        InlineKeyboardButton past = new InlineKeyboardButton();
        past.setText("Past tenses");
        past.setCallbackData("ShowPastTenses");
        startMenuButtons.add(past);

        InlineKeyboardButton future = new InlineKeyboardButton();
        future.setText("Future tenses");
        future.setCallbackData("ShowFutureTenses");
        startMenuButtons.add(future);

        InlineKeyboardMarkup startButtons = new InlineKeyboardMarkup();
        startButtons.setKeyboard(List.of(startMenuButtons));

        return startButtons;
    }

    @Override
    public String getBotUsername() {
        return "English grammar";
    }
}
