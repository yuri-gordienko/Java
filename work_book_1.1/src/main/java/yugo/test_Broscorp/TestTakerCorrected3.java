package yugo.test_Broscorp;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestTakerCorrected3 {

    public static String[] sorted(String[] events) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate now = LocalDate.of(1900, 1, 1);

        List<String> listOfEvents = new java.util.ArrayList<>();
        for (String event : events) {
            Optional<LocalDate> date = findDateInLine(event, formatter);
            if (date.isEmpty()) continue;

            Period timeLeft = Period.between(now, date.get());

            // Виправлення: замість indexOf використовуємо lastIndexOf для отримання останнього входження дати
            int dateIndex = event.lastIndexOf(date.get().format(formatter));

            // Отримуємо назву події, ігноруючи пробіли в кінці
            String title = event.substring(0, dateIndex).trim();

            StringBuilder sb = new StringBuilder();
            sb.append(timeLeft.getYears()).append("years;")
                    .append(timeLeft.getMonths()).append("months;")
                    .append(timeLeft.getDays()).append("days-")
                    .append(title);
            listOfEvents.add(sb.toString());
        }

        listOfEvents.sort((String e1, String e2) -> e1.compareTo(e2));

        return listOfEvents.toArray(new String[0]);
    }

    private static Optional<LocalDate> findDateInLine(String line, DateTimeFormatter formatter) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
        if (m.find()) {
            return Optional.of(LocalDate.parse(m.group(), formatter));
        }
        return Optional.empty();
    }
}