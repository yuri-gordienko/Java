package yugo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
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
public class VacanciesBot extends TelegramLongPollingBot { // основний клас, стагуватиме вакансіі з певних ресурсів

    @Autowired
    private VacancyService vacancyService;

    // создаем место хранения истории, где пользователь был перед этим (в каком меню)
    private final Map<Long, String> lastShowWacancyLevel = new HashMap<>();

    public VacanciesBot() {    // botToken сформировали в телеграм с помощью канала BotFather
        // телеграм буде розуміти хто звертається до нього (що ми адмін) та якими повідомленнями відпвідати

        super("6609052827:AAFkqvDA6VoOoGHHvYEBWfwVa3jQoXIbJKI");
    }

    @Override
    public void onUpdateReceived(Update update) { // обработка сообщений от пользователя через входящий объект Update
       try {
           if (update.getMessage() !=null) {    // якщо прілітає перше повідомлення не пусте, то викликаєм метод
               handleStartCommand(update);  // щоб не було Налпоінтерєксепшн
           }
           if (update.getCallbackQuery() != null) { // після натискання на кнопку-меню, яку обрав юзер, перевіряємо на налл
               String callBackdata = update.getCallbackQuery().getData();   // тоді викликаєм метод-відповідь на запит
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
           throw new RuntimeException("Can't send message to user!", e);
       }
    }

    private void handleBackToVacCommand(Update update) throws TelegramApiException { // метод возврата назад, важно попасть в то меню, в кот.находильсь
        // делаем идентификатор пользователя, чтоб запомнить какой пользователь заходил из какого меню, чтоб  возвращать его туда же
        Long chatId = update.getCallbackQuery().getMessage().getChatId(); // отримали ключ для мапи (це id юзера)
        String level = lastShowWacancyLevel.get(chatId); // вытягиваем из мапы историю откуда заходили
        if ("junior".equals(level)) {
            showJuniorVacancies(update);
        } else if ("middle".equals(level)) {    // інакше
            showMiddleVacancies(update);
        } else if ("senior".equals(level)) {    // інакше
            showSeniorVacancies(update);
        }
    }

    private void handleBackToStartCommand (Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("You can choose any other title:");
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setReplyMarkup(getStartMenu());
        execute(sendMessage);
    }

    private void showVacancyDescription(String id, Update update) throws TelegramApiException {
        VacancyDto vacancyDto = vacancyService.get(id);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
//        String description = vacancy.getShortDescription();
        String vacancyInfo = """        
            *Title:* %s
            *Company:* %s \n
            *Short Description:* %s \n
            *Description:* %s \n
            *Salary:* %s \n
            *Link:* [%s](%s)
            """.formatted(
    // це - якби шаблон, для оформлення тексту в боті
    // підставляємо дані з вакансіі, *Title* буде підзаголовком, а замість %s буде підставлятися інфо з вакансії
                    escapeMarkdownReservedChars(vacancyDto.getTitle()), // витягуєм дані для заповнення
                escapeMarkdownReservedChars(vacancyDto.getCompany()),
                escapeMarkdownReservedChars(vacancyDto.getShortDescription()),
                escapeMarkdownReservedChars(vacancyDto.getLongDescription()),
                // перевіряємо поле зарплатні. якщо пусте ? виводимо текст : а якщо Ні, то виводимо дані
                vacancyDto.getSalary().isBlank() ? "Not specified" : escapeMarkdownReservedChars(vacancyDto.getSalary()),
                "Click here for more details",
                escapeMarkdownReservedChars(vacancyDto.getLink()) // лінк вказується у спеціальному форматі:
                // [%s] це текст, (%s) а це сам лінк
        );
        sendMessage.setText(vacancyInfo);
        sendMessage.setParseMode(ParseMode.MARKDOWNV2); // бібліотека телеграма, що надає такий функціонал
        sendMessage.setReplyMarkup(getBackToVacanciesMenu());   // создаем кнопочку "Назад"
        execute(sendMessage);
    }

    private String escapeMarkdownReservedChars(String text) { // дозволяє заескейпити чарактери, щоб прикрасити текст
        return text.replace("-", "\\-") // називається екранування символів
                .replace("_", "\\_")
                .replace("*", "\\*")
                .replace("[", "\\[")
                .replace("]", "\\]")
                .replace("(", "\\(")
                .replace(")", "\\)")
                .replace("`", "\\'")
                .replace(">", "\\>")
                .replace("#", "\\#")
                .replace("+", "\\+")
                .replace(".", "\\.")
                .replace("!", "\\!")
                .replace("~", "\\~");
    }

    private ReplyKeyboard getBackToVacanciesMenu() {    // метод по создании кнопочки "Назад" и "Домой"
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton backToVac = new InlineKeyboardButton();
        backToVac.setText("Back");
        backToVac.setCallbackData("backToVacancies");
        row.add(backToVac);

        InlineKeyboardButton home = new InlineKeyboardButton();
        home.setText("Home");
        home.setCallbackData("backToStartMenu");
        row.add(home);

        InlineKeyboardButton chatGpt = new InlineKeyboardButton();
        chatGpt.setText("Get cover letter");
        chatGpt.setUrl("https://chat.openai.com/");
        row.add(chatGpt);
        
        return new InlineKeyboardMarkup(List.of(row));
    }

    private void showJuniorVacancies(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();    // создаем ответ пользователю
        sendMessage.setText("Choose any vacancy:");  // создаем смс
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId); // отправляем смс конкретному пользователю
        sendMessage.setReplyMarkup(getJuniorMessagesMenu());    // отправляем меню пользователю
        execute(sendMessage);

        lastShowWacancyLevel.put(chatId, "junior"); // записываем истоию посещений, чтоб потом отдать
    }

    private void showMiddleVacancies(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();    // создаем ответ пользователю
        sendMessage.setText("Choose any vacancy:");  // создаем смс
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        sendMessage.setChatId(chatId);        sendMessage.setReplyMarkup(getMiddleMessagesMenu());
        execute(sendMessage);

        lastShowWacancyLevel.put(chatId, "middle");
    }

    private void showSeniorVacancies(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();    // создаем ответ пользователю
        sendMessage.setText("Choose any vacancy:");  // создаем смс
        Long chatId = update.getCallbackQuery().getMessage().getChatId();   // зробили змінну для запису в Мапу
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(getSeniorMessagesMenu());
        execute(sendMessage);

        lastShowWacancyLevel.put(chatId, "senior");     // записуємо в Мапу історію звідки зайшов юзер, щоб потім повертатися
    }                                                    // назад для кнопки "Назад до попереднього меню"


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
//        InlineKeyboardMarkup keybord = new InlineKeyboardMarkup();
//        keybord.setKeyboard(List.of(row));
//        return keybord;
        return new InlineKeyboardMarkup(List.of(row));      // інший коротший варіант повертати List
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
        sendMessage.setText("WELCOME TO VACANCIES SEARCH APPLICATION ! \n" +
                "Here you can find vacancies by different work experience. \n" +
                "You can choose any title:"); // метод ввода текста пользователю
        sendMessage.setReplyMarkup(getStartMenu()); // // виклик getStartMenu
        try {
            execute(sendMessage);   //отправка смс
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private ReplyKeyboard getStartMenu() {  // отрисовываем кнопки
        List<InlineKeyboardButton> row = new ArrayList<>(); // створили масив кнопок

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

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(); // новий обєкт для повкрнення кнопок
        keyboard.setKeyboard(List.of(row));  // возвращаем перечень вакансий
        return keyboard;
    }

    @Override
    public String getBotUsername() {    // возвращаем имя бота

        return "yugo vacancies-bot";
    }
}
