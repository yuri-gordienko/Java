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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EnglishGrammarBot extends TelegramLongPollingBot {

    private final Map<Long, String> chatHistoryForBackMenu = new HashMap<>();

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
                } else if ("ShowPastTenses".equals(callbackData)) {
                    showPastTenses(update);

                } else if ("ShowFutureTenses".equals(callbackData)) {
                    showFutureTenses(update);

                } else if (callbackData.startsWith("tenseId=")) {
                    String id = callbackData.split("=")[1];
                    showSpecificallyTensesDescription(id, update);
                } else if ("back_to_main_menu".equals(callbackData)) {
                    historyOfPreviousUserAttendance(update);
                } else if ("back_to_start_menu".equals(callbackData)) {

                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't send message to user!", e);
        }
    }

    private void historyOfPreviousUserAttendance(Update update) throws TelegramApiException {
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        String level = chatHistoryForBackMenu.get(chatId);

        if ("present".equals(level)) {
            showPresentTenses(update);
        } else if ("past".equals(level)) {
            showPastTenses(update);
        } else if ("future".equals(level)) {
            showFutureTenses(update);
        }
    }

        private void showSpecificallyTensesDescription(String id, Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        EnglishGrammarBotDto tense = englishGrammarBotService.get(id);
        String description = tense.getShortDescription();
        sendMessage.setText(description);
        sendMessage.setReplyMarkup(getBackToMenu());
        execute(sendMessage);
    }

    private ReplyKeyboard getBackToMenu() {
        List<InlineKeyboardButton> backButtons = new ArrayList<>();

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Back to main menu");
        back.setCallbackData("back_to_main_menu");
        backButtons.add(back);

        InlineKeyboardButton backToStart = new InlineKeyboardButton();
        backToStart.setText("Back to start menu");
        backToStart.setCallbackData("back_to_start_menu");
        backButtons.add(backToStart);

        return new InlineKeyboardMarkup(List.of(backButtons));
    }

    private void showFutureTenses(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Specifically by Future tense:");
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(getFutureTensesMenu());
        execute(sendMessage);

        chatHistoryForBackMenu.put(chatId, "future");
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

        InlineKeyboardMarkup pastMenu = new InlineKeyboardMarkup();
        pastMenu.setKeyboard(List.of(subMenuButtons));

        return pastMenu;
    }

    private void showPastTenses(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Specifically by Past tense:");
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(getPastTensesMenu());
        execute(sendMessage);

        chatHistoryForBackMenu.put(chatId, "past");
    }

    private ReplyKeyboard getPastTensesMenu() {
        List<InlineKeyboardButton> subMenuButtons = new ArrayList<>();

        List<EnglishGrammarBotDto> listDtoTenses = englishGrammarBotService.getPastSpecifically();
        for (EnglishGrammarBotDto listDTOTense : listDtoTenses) {
            InlineKeyboardButton tenseButton = new InlineKeyboardButton();
            tenseButton.setText(listDTOTense.getTense());
            tenseButton.setCallbackData("tenseId=" + listDTOTense.getId());
            subMenuButtons.add(tenseButton);
        }

        InlineKeyboardMarkup pastMenu = new InlineKeyboardMarkup();
        pastMenu.setKeyboard(List.of(subMenuButtons));

        return pastMenu;
    }

    private void showPresentTenses(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Specifically by Present tense:");
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(getPresentTensesMenu());
        execute(sendMessage);

        chatHistoryForBackMenu.put(chatId, "present");
    }

    private ReplyKeyboard getPresentTensesMenu() {
        List<InlineKeyboardButton> subMenuButtons = new ArrayList<>();

        List<EnglishGrammarBotDto> listDtoTenses = englishGrammarBotService.getPresentSpecifically();
        for (EnglishGrammarBotDto listDTOTense : listDtoTenses) {
            InlineKeyboardButton tenseButton = new InlineKeyboardButton();
            tenseButton.setText(listDTOTense.getTense());
            tenseButton.setCallbackData("tenseId=" + listDTOTense.getId());
            subMenuButtons.add(tenseButton);
        }

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

//        InlineKeyboardMarkup startButtons = new InlineKeyboardMarkup();
//        startButtons.setKeyboard(List.of(startMenuButtons));

//        return startButtons;
        return new InlineKeyboardMarkup(List.of(startMenuButtons));
    }

    @Override
    public String getBotUsername() {
        return "English grammar";
    }
}
