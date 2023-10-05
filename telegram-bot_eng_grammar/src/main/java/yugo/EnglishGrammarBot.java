package yugo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import yugo.dto.EnglishGrammarBotDto;
import yugo.service.EnglishGrammarBotService;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnglishGrammarBot extends TelegramLongPollingBot {

    @Autowired
    private EnglishGrammarBotService englishGrammarBotService;

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
                } else if (callbackData.startsWith("vacancyId=")) {
                    String id = callbackData.split("=")[1];
                    showPresentTensesDescription(id, update);
                }
                if ("ShowPastTenses".equals(callbackData)) {
                    showPastTenses(update);
                }
//                else if (callbackData.startsWith("id")) {
//                    showPastTensesDescription(id, update);
//                }
                if ("ShowFutureTenses".equals(callbackData)) {
                    showFutureTenses(update);
                }
//                else if (callbackData.equals("id")) {
//                    showFutureTensesDescription(id, update);
//                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't send message to user!", e);
        }
    }

    private void showPresentTensesDescription(String id, Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        EnglishGrammarBotDto tense = englishGrammarBotService.get(id);
        String description = tense.getShortDescription();
        sendMessage.setText(description);
        execute(sendMessage);
    }

    private void showFutureTenses(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Specifically by Future tense:");
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setReplyMarkup(getFutureTensesMenu());
        execute(sendMessage);
    }

    private ReplyKeyboard getFutureTensesMenu() {
        List<InlineKeyboardButton> subMenuButtons = new ArrayList<>();

        List<EnglishGrammarBotDto> listDtoTenses = englishGrammarBotService.getFutureSpecifically();

        for (EnglishGrammarBotDto listDTOTense : listDtoTenses) {
            InlineKeyboardButton tenseButton = new InlineKeyboardButton();
            tenseButton.setText(listDTOTense.getTense());
            tenseButton.setCallbackData("tenseId=" + listDTOTense.getId());
            subMenuButtons.add(tenseButton);
        }


        InlineKeyboardButton simple = new InlineKeyboardButton();
        simple.setText("Simple");
        simple.setCallbackData("tenseId=1");
        subMenuButtons.add(simple);

        InlineKeyboardButton continuous = new InlineKeyboardButton();
        continuous.setText("Continuous");
        continuous.setCallbackData("tenseId=2");
        subMenuButtons.add(continuous);

        InlineKeyboardButton perfect = new InlineKeyboardButton();
        perfect.setText("Perfect");
        perfect.setCallbackData("show_future_perfect");
        subMenuButtons.add(perfect);

        InlineKeyboardButton pf = new InlineKeyboardButton();
        pf.setText("Perfect Continuous");
        pf.setCallbackData("show_future_perf_cont");
        subMenuButtons.add(pf);

        InlineKeyboardMarkup pastMenu = new InlineKeyboardMarkup();
        pastMenu.setKeyboard(List.of(subMenuButtons));

        return pastMenu;
    }

    private void showPastTenses(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Specifically by Past tense:");
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setReplyMarkup(getPastTensesMenu());
        execute(sendMessage);
    }

    private ReplyKeyboard getPastTensesMenu() {
        List<InlineKeyboardButton> subMenuButtons = new ArrayList<>();

        InlineKeyboardButton simple = new InlineKeyboardButton();
        simple.setText("Simple");
        simple.setCallbackData("show_past_simple");
        subMenuButtons.add(simple);

        InlineKeyboardButton continuous = new InlineKeyboardButton();
        continuous.setText("Continuous");
        continuous.setCallbackData("show_past_continuous");
        subMenuButtons.add(continuous);

        InlineKeyboardButton perfect = new InlineKeyboardButton();
        perfect.setText("Perfect");
        perfect.setCallbackData("show_past_perfect");
        subMenuButtons.add(perfect);

        InlineKeyboardButton pf = new InlineKeyboardButton();
        pf.setText("Perfect Continuous");
        pf.setCallbackData("show_past_perf_cont");
        subMenuButtons.add(pf);

        InlineKeyboardMarkup pastMenu = new InlineKeyboardMarkup();
        pastMenu.setKeyboard(List.of(subMenuButtons));

        return pastMenu;
    }

    private void showPresentTenses(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Specifically by Present tense:");
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
