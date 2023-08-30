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
import yugo.dto.VacancyDto;
import yugo.service.VacancyService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VacanciesBot extends TelegramLongPollingBot {

    @Autowired
    private VacancyService vacancyService;

    // создаем место хранения истории, где пользователь был перед этим (в каком меню)
    private final Map<Long, String> lastShowWacancyLevel = new HashMap<>();

    public VacanciesBot() {    // botToken сформировали в телеграм с помощью канала BotFather

        super("6609052827:AAFkqvDA6VoOoGHHvYEBWfwVa3jQoXIbJKI");
    }

    @Override
    public void onUpdateReceived(Update update) { // обработка сообщений от пользователя через входящий объект Update
       try {
           if (update.getMessage() !=null) {
               handleStartCommand(update);
           }
           if (update.getCallbackQuery() != null) {
               String callBackdata = update.getCallbackQuery().getData();
               if ("showJuniorVacancies".equals(callBackdata)) {    // проверяем соответствует ли нажатая кнопка методу
                   showJuniorVacancies(update); // возвращаем ответ
               } else if ("showMiddleVacancies".equals(callBackdata)) {    // проверяем соответствует ли нажатая кнопка методу
                   showMiddleVacancies(update);
               } else if ("showSeniorVacancies".equals(callBackdata)) {    // проверяем соответствует ли нажатая кнопка методу
                   showSeniorVacancies(update);
               } else if (callBackdata.startsWith("vacancyId=")) {
                   String id = callBackdata.split("=")[1]; // [1] - берем левую часть (вторую), т.к. отсчет начинается с 0, то 1 это два
                   showVacancyDescription(id, update);
               } else if ("backToVacancies".equals(callBackdata)) {
                   handleBackToVacCommand(update);
               } else if ("backToStartMenu".equals(callBackdata)) {
                   handleBackToStartCommand(update);
               }
           }
       } catch (Exception e) {
           throw new RuntimeException("Can't send message to user", e);
       }
    }

    private void handleBackToVacCommand(Update update) throws TelegramApiException { // метод возврата назад, важно попасть в то меню, в кот.находильсь
        // делаем идентификатор пользователя, чтоб запомнить какой пользователь заходил из какого меню, чтоб  возвращать его туда же
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        String level = lastShowWacancyLevel.get(chatId); // вытягиваем из мапы историю

        if ("junior".equals(level)) {
            showJuniorVacancies(update);
        } else if ("middle".equals(level)) {
            showMiddleVacancies(update);
        } else if ("senior".equals(level)) {
            showSeniorVacancies(update);
        }
    }

    private void handleBackToStartCommand (Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Choose title:");
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setReplyMarkup(getStartMenu());
        execute(sendMessage);
    }

    private void showVacancyDescription(String id, Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        VacancyDto vacancy = vacancyService.get(id);
        String description = vacancy.getShortDescription();
        sendMessage.setText(description);
        sendMessage.setReplyMarkup(getBackToVacanciesMenu());   // создаем кнопочку "Назад"
        execute(sendMessage);
    }

    private ReplyKeyboard getBackToVacanciesMenu() {    // метод по создании кнопочки "Назад"
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton backToVac = new InlineKeyboardButton();
        backToVac.setText("Back");
        backToVac.setCallbackData("backToVacancies");
        row.add(backToVac);

        InlineKeyboardButton home = new InlineKeyboardButton();
        home.setText("Home");
        home.setCallbackData("backToStartMenu");
        row.add(home);
        
        return new InlineKeyboardMarkup(List.of(row));
    }

    private void showJuniorVacancies(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();    // создаем ответ пользователю
        sendMessage.setText("Please, choose vacancy");  // создаем смс
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId); // отправляем смс конкретному пользователю
        sendMessage.setReplyMarkup(getJuniorMessagesMenu());    // отправляем меню пользователю
        execute(sendMessage);

        lastShowWacancyLevel.put(chatId, "junior"); // записываем истоию посещений, чтоб потом отдать
    }

    private void showMiddleVacancies(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();    // создаем ответ пользователю
        sendMessage.setText("Please, choose vacancy");  // создаем смс
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId);        sendMessage.setReplyMarkup(getMiddleMessagesMenu());
        execute(sendMessage);

        lastShowWacancyLevel.put(chatId, "middle");
    }

    private void showSeniorVacancies(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();    // создаем ответ пользователю
        sendMessage.setText("Please, choose vacancy");  // создаем смс
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(getSeniorMessagesMenu());
        execute(sendMessage);

        lastShowWacancyLevel.put(chatId, "senior");
    }

    private ReplyKeyboard getJuniorMessagesMenu() { // формируем перечень кнопок в соответствии с нашими вакансиями
        List<InlineKeyboardButton> row = new ArrayList<>();

        List<VacancyDto> vacancies = vacancyService.getJunVac(); // получаем список джуниор вакансий
        for (VacancyDto vacancy : vacancies) {  // бежим по массиву и для каждой вакансии
            InlineKeyboardButton vacancyButton = new InlineKeyboardButton();   // формируем кнопку
            vacancyButton.setText(vacancy.getTitle());  // на кнопке прописываем название вакансии
            vacancyButton.setCallbackData("vacancyId=" + vacancy.getId()); // сутаем колбэкдату
            row.add(vacancyButton);
        }
//        Назначаем принудительно
//        InlineKeyboardButton amazonVacancy = new InlineKeyboardButton();   // создали вакансию конкретной фирмы
//        amazonVacancy.setText("Junior Java dev at Amazon");
//        amazonVacancy.setCallbackData("vacancyId=1");
//        row.add(amazonVacancy);
//
//        InlineKeyboardButton googleVacancy = new InlineKeyboardButton();   // создали вакансию конкретной фирмы
//        googleVacancy.setText("Junior Java dev at Google");
//        googleVacancy.setCallbackData("vacancyId=2");
//        row.add(googleVacancy);

        InlineKeyboardMarkup keybord = new InlineKeyboardMarkup();
        keybord.setKeyboard(List.of(row));  // возвращаем перечень вакансий
        return keybord;
    }

    private ReplyKeyboard getMiddleMessagesMenu() {
        List<InlineKeyboardButton> row = new ArrayList<>();

        List<VacancyDto> vacancies = vacancyService.getMidVac();
        for (VacancyDto vacancy : vacancies) {
            InlineKeyboardButton vacancyButton = new InlineKeyboardButton();
            vacancyButton.setText(vacancy.getTitle());
            vacancyButton.setCallbackData("vacancyId=" + vacancy.getId());
            row.add(vacancyButton);
        }
        InlineKeyboardMarkup keybord = new InlineKeyboardMarkup();
        keybord.setKeyboard(List.of(row));
        return keybord;
    }

    private ReplyKeyboard getSeniorMessagesMenu() {
        List<InlineKeyboardButton> row = new ArrayList<>();

        List<VacancyDto> vacancies = vacancyService.getSeniorVac();
        for (VacancyDto vacancy : vacancies) {
            InlineKeyboardButton vacancyButton = new InlineKeyboardButton();
            vacancyButton.setText(vacancy.getTitle());
            vacancyButton.setCallbackData("vacancyId=" + vacancy.getId());
            row.add(vacancyButton);
        }
        InlineKeyboardMarkup keybord = new InlineKeyboardMarkup();
        keybord.setKeyboard(List.of(row));
        return keybord;
    }

    private void handleStartCommand (Update update) {
        String text = update.getMessage().getText(); // метод принятия смс от пользователей
        System.out.println("user: " + text);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());  // метод идентификации чата
        sendMessage.setText("Welcome to vacancies-bot! Please, choose your title:"); // метод ввода текста пользователю
        sendMessage.setReplyMarkup(getStartMenu()); // создаем менюшку
        try {
            execute(sendMessage);   //отправка смс
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private ReplyKeyboard getStartMenu() {  // отрисовываем кнопки
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton junior = new InlineKeyboardButton();   // создали кнопку
        junior.setText("Junior");   // дали название кнопке
        junior.setCallbackData("showJuniorVacancies"); // смс от телеграм на клик от пользователя, чтоб понять какую именно кнопку выбрал пользователь
        row.add(junior);

        InlineKeyboardButton middle = new InlineKeyboardButton();   // создали кнопку
        middle.setText("Middle");   // дали название кнопке
        middle.setCallbackData("showMiddleVacancies"); // смс от телеграм на клик от пользователя, чтоб понять какую именно кнопку выбрал пользователь
        row.add(middle);

        InlineKeyboardButton senior = new InlineKeyboardButton();   // создали кнопку
        senior.setText("Senior");   // дали название кнопке
        senior.setCallbackData("showSeniorVacancies"); // смс от телеграм на клик от пользователя, чтоб понять какую именно кнопку выбрал пользователь
        row.add(senior);

        InlineKeyboardMarkup keybord = new InlineKeyboardMarkup();
        keybord.setKeyboard(List.of(row));  // возвращаем перечень вакансий
        return keybord;
    }

    @Override
    public String getBotUsername() {    // возвращаем имя бота
        return "yugo vacancies-bot";
    }
}
