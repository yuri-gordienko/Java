package yugo.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

import static yugo.util.TelegramBotContent.*;
import static yugo.util.TelegramBotUtils.*;

public class CatHackerBotServiceRefactoringCode extends TelegramLongPollingBot {

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
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            SendMessage sendMessage = createMessage(chatId, INTRO_TEXT);
            sendApiMethodAsync(sendMessage);

            sendMessage(chatId, 0, "step_1_pic", STEP_1_TEXT,
                    Map.of("Злам холодильника", "step_1_btn"));
        }

        if (update.hasCallbackQuery()) {
            if (update.getCallbackQuery().getData().equals("step_1_btn") && getGlories(chatId) == 0) {
                sendMessage(chatId, 10, "step_2_pic", STEP_2_TEXT,
                        Map.of("Взяти сосиску! +10 €", "step_2_btn",
                                "Взяти рибку! +10 €", "step_2_btn",
                                "Скинути банку з огірками! +10 €", "step_2_btn"));
            }
            if (update.getCallbackQuery().getData().equals("step_2_btn") && getGlories(chatId) == 10) {
                sendMessage(chatId, 1, "step_3_pic", STEP_3_TEXT,
                        Map.of("Злам робота пилососа", "step_3_bth"));
            }
            if (update.getCallbackQuery().getData().equals("step_3_bth") && getGlories(chatId) == 11) {
                sendMessage(chatId, 20, "step_4_pic", STEP_4_TEXT,
                        Map.of("Відправити робопилосос за їжею! +20 €", "step_4_btn",
                                "Проїхатися на робопилососі! +20 €", "step_4_btn",
                                "Тікати від робопилососа! +20 €", "step_4_btn"));
            }
            if (update.getCallbackQuery().getData().equals("step_4_btn") && getGlories(chatId) == 31) {
                sendMessage(chatId, 2, "step_5_pic", STEP_5_TEXT,
                        Map.of("Одягнути та включити GoPro!", "step_5_bth"));
            }
            if (update.getCallbackQuery().getData().equals("step_5_bth") && getGlories(chatId) == 33) {
                sendMessage(chatId, 40, "step_6_pic", STEP_6_TEXT,
                        Map.of("Бігати дахами, знімати на GoPro! +30 €", "step_6_btn",
                                "З GoPro нападати на інших котів із засідки! +30 €", "step_6_btn",
                                "З GoPro нападати на собак із засідки! +30 €", "step_6_btn"));
            }
            if (update.getCallbackQuery().getData().equals("step_6_btn") && getGlories(chatId) == 73) {
                sendMessage(chatId, 3, "step_7_pic", STEP_7_TEXT,
                        Map.of("Злам пароля", "step_7_bth"));
            }
            if (update.getCallbackQuery().getData().equals("step_7_bth") && getGlories(chatId) == 76) {
                sendMessage(chatId, 80, "step_8_pic", STEP_8_TEXT,
                        Map.of("Вийти на подвір'я", "step_8_bth"));
            }
            if (update.getCallbackQuery().getData().equals("step_8_bth") && getGlories(chatId) == 156) {
                sendMessage(chatId, 100, "final_pic", FINAL_TEXT,
                        new HashMap<>());

                SendMessage sendMessage = createMessage(chatId, SAY_GOODBYE);
                sendApiMethodAsync(sendMessage);
            }
        }
    }

    private void sendMessage(Long chatId, int glories, String pictureName, String text, Map<String, String> buttons) {
        addGlories(chatId, glories);
        SendPhoto sendPhoto = createPhotoMessage(chatId, pictureName);
        executeAsync(sendPhoto);
        SendMessage message = createMessage(chatId, text, buttons);
        sendApiMethodAsync(message);
    }
}
