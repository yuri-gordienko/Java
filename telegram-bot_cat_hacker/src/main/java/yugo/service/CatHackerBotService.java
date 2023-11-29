package yugo.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

import static yugo.util.TelegramBotContent.*;
import static yugo.util.TelegramBotUtils.*;

public class CatHackerBotService extends TelegramLongPollingBot {

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
// update.hasMessage()) перевіряємо чи є взагалі напечатана смс від будь-якого юзера (цей метод саме для тексту)
// якщо є повідомдення і воно дорівнює /start, то відповідаємо згідно з id, пишимо текст, створюємо кнопку і відправляємо дані юзеру
// addGlories - метод, що додає бали за виконання (відпрацьовує певна кнопка)
// є бага, якщо нажимати не одноразово кнопку "/start", то постійно буде визиватися стартове меню, пофіксили методом getGlories
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) { // equals обов'язково точно "/start"
            SendMessage sendMessage = createMessage(chatId, INTRO_TEXT);
            sendApiMethodAsync(sendMessage);

            addGlories(chatId, 0);
            SendPhoto photoMessage = createPhotoMessage(chatId, "step_1_pic");
            executeAsync(photoMessage);
            SendMessage message = createMessage(chatId, STEP_1_TEXT,
                    Map.of("Злам холодильника", "step_1_btn"));
            sendApiMethodAsync(message);
        }

// getGlories додає бали за виконання і також перевіряє на наявність балів за попередній період, і якщо вони співпадають,
// то тільки у тому разі, ми даємо спрацювати кнопці (щоб не було баги, що можна не однарозово визивати одне і теж меню)
        if (update.hasCallbackQuery()) { // усі кнопки створюємо у середені цього if, т.я. перевіряє на наявність даних від юзера
            if (update.getCallbackQuery().getData().equals("step_1_btn") && getGlories(chatId) == 0) {
                addGlories(chatId, 10);
                SendPhoto photoMessage = createPhotoMessage(chatId, "step_2_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, STEP_2_TEXT,
                        Map.of("Взяти сосиску! +10 €", "step_2_btn",
                                "Взяти рибку! +10 €", "step_2_btn",
                                "Скинути банку з огірками! +10 €", "step_2_btn"));
                sendApiMethodAsync(message);
            }
            if (update.getCallbackQuery().getData().equals("step_2_btn") && getGlories(chatId) == 10) {
                addGlories(chatId, 1);
                SendPhoto photoMessage = createPhotoMessage(chatId, "step_3_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, STEP_3_TEXT,
                        Map.of("Злам робота пилососа", "step_3_bth"));
                sendApiMethodAsync(message);
            }
            if (update.getCallbackQuery().getData().equals("step_3_bth") && getGlories(chatId) == 11) {
                addGlories(chatId, 20);
                SendPhoto photoMessage = createPhotoMessage(chatId, "step_4_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, STEP_4_TEXT,
                        Map.of("Відправити робопилосос за їжею! +20 €", "step_4_btn",
                                "Проїхатися на робопилососі! +20 €", "step_4_btn",
                                "Тікати від робопилососа! +20 €", "step_4_btn"));
                sendApiMethodAsync(message);
            }
            if (update.getCallbackQuery().getData().equals("step_4_btn") && getGlories(chatId) == 31) {
                addGlories(chatId, 2);
                SendPhoto photoMessage = createPhotoMessage(chatId, "step_5_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, STEP_5_TEXT,
                        Map.of("Одягнути та включити GoPro!", "step_5_bth"));
                sendApiMethodAsync(message);
            }
            if (update.getCallbackQuery().getData().equals("step_5_bth") && getGlories(chatId) == 33) {
                addGlories(chatId, 40);
                SendPhoto photoMessage = createPhotoMessage(chatId, "step_6_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, STEP_6_TEXT,
                        Map.of("Бігати дахами, знімати на GoPro! +30 €", "step_6_btn",
                                "З GoPro нападати на інших котів із засідки! +30 €", "step_6_btn",
                                "З GoPro нападати на собак із засідки! +30 €", "step_6_btn"));
                sendApiMethodAsync(message);
            }
            if (update.getCallbackQuery().getData().equals("step_6_btn") && getGlories(chatId) == 73) {
                addGlories(chatId, 3);
                SendPhoto photoMessage = createPhotoMessage(chatId, "step_7_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, STEP_7_TEXT,
                        Map.of("Злам пароля", "step_7_bth"));
                sendApiMethodAsync(message);
            }
            if (update.getCallbackQuery().getData().equals("step_7_bth") && getGlories(chatId) == 76) {
                addGlories(chatId, 80);
                SendPhoto photoMessage = createPhotoMessage(chatId, "step_8_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, STEP_8_TEXT,
                        Map.of("Вийти на подвір'я", "step_8_bth"));
                sendApiMethodAsync(message);
            }
            if (update.getCallbackQuery().getData().equals("step_8_bth") && getGlories(chatId) == 156) {
                clearGlories(chatId);
                SendPhoto photoMessage = createPhotoMessage(chatId, "final_pic");
                executeAsync(photoMessage);
                SendMessage message = createMessage(chatId, FINAL_TEXT);
                sendApiMethodAsync(message);

                SendMessage sendMessage = createMessage(chatId, SAY_GOODBYE);
                sendApiMethodAsync(sendMessage);
            }
        }
    }
}
