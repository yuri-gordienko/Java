package yugo.test_Broscorp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestTakerCorrected {

    public static String[] sorted(String[] events) {

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate now = LocalDate.of(1900, 1, 1); // Исправлено на 1900 год

        List<String> listOfEvents = new ArrayList<>();
        for (String event : events) {
            Optional<LocalDate> date = findDateInLine(event, formatter);
            if (date.isEmpty()) continue;
            Period timeLeft = Period.between(now, date.get()); // Исправлено на расчет времени до даты

            int dateIndex = event.indexOf(date.get().format(formatter));
            String title = event.substring(0, dateIndex - 1); // Исправлено на правильный индекс
            StringBuilder sb = new StringBuilder();
            sb.append(timeLeft.getYears()).append("years;")
                    .append(timeLeft.getMonths()).append("months;")
                    .append(timeLeft.getDays()).append("days-").append(title);
            listOfEvents.add(sb.toString());
        }
        listOfEvents.sort((e1, e2) -> e1.compareTo(e2));

        return listOfEvents.toArray(new String[0]); // Исправлено на более короткую форму
    }

    private static Optional<LocalDate> findDateInLine(String line,
                                                      DateTimeFormatter formatter) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
        if (m.find()) {
            return Optional.of(LocalDate.parse(m.group(), formatter)); // Исправлено на возврат Optional с датой
        }
        return Optional.empty();
    }
}

//public class TestTakerCorrected {
//
//    public static String[] sorted(String[] events) {
//
//        final java.time.format.DateTimeFormatter formatter =
//                java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        final java.time.LocalDate now = java.time.LocalDate.of(1900, 1, 1);
//
//        java.util.List<String> listOfEvents = new java.util.ArrayList<>();
//        for (String event : events) {
//            java.util.Optional<java.time.LocalDate> date = findDateInLine(event, formatter);
//            if (date.isEmpty()) continue;
//            java.time.Period timeLeft = java.time.Period.between(now, date.get());
//
//            int dateIndex = event.indexOf(date.get().format(formatter));
//            String title = event.substring(0, dateIndex - 1);
//            StringBuilder sb = new StringBuilder();
//            sb.append(timeLeft.getYears()).append("years;")
//                    .append(timeLeft.getMonths()).append("months;")
//                    .append(timeLeft.getDays()).append("days-").append(title);
//            listOfEvents.add(sb.toString());
//        }
//        listOfEvents.sort((e1, e2) -> e1.compareTo(e2));
//
//        return listOfEvents.toArray(new String[0]);
//    }
//
//    private static java.util.Optional<java.time.LocalDate> findDateInLine(String line,
//                                                                          java.time.format.DateTimeFormatter formatter) {
//        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
//        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
//        if (m.find()) {
//            return java.util.Optional.of(java.time.LocalDate.parse(m.group(), formatter));
//        }
//        return java.util.Optional.empty();
//    }
//}