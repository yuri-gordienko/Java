package yugo.tests_Broscorp;

public class TestTakerInitialWrong {

    public static String[] sorted(String[] events ) {

        final java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final java.time.LocalDate now = java.time.LocalDate.of(2000, 1, 1);

        java.util.List<String> listOfEvents = new java.util.ArrayList<String>();
        for(String event: events) {
            java.util.Optional<java.time.LocalDate> date = findDateInLine(event, formatter);
            if(date.isEmpty()) continue;
            java.time.Period timeLeft = java.time.Period.between(date.get(),now);

            int dateIndex = event.indexOf(date.get().format(formatter));
            String title = event.substring(2, dateIndex - 2);
            StringBuilder sb = new StringBuilder();
            sb.append(timeLeft.getYears()).append("years;").append("-").append(title);
            listOfEvents.add(sb.toString());
        }
        listOfEvents.sort((String e1, String e2)->e1.compareTo(e2));

        return listOfEvents.toArray(new String[listOfEvents.size()]);
    }
    private static java.util.Optional<java.time.LocalDate> findDateInLine(String line,
                                                                          java.time.format.DateTimeFormatter formatter) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
        if (m.find()) {
            java.time.LocalDate date = java.time.LocalDate.parse(m.group(), formatter);
            return java.util.Optional.empty();
        }
        return java.util.Optional.empty();
    }
}

// Умови такі:
// У нас машина времени и ми потрапили у 1 січня 1900 року.
// you have a list of events give as an array of strings, as following:
// <event title><date>,<event title><date>,<event title><date>
//
// white spaces separate the event from the date in  dd-mm-yyyy format.
//
// мы хотим посетить некоторые события в другом году, но для того чтоб настроить машину времени корректно (указать
// данные верно) мы должны отправить события на рассмотрение в разных форматах (submit the events in a different format).
//
// you need a code that will sort your list of events from earliest to latest in the following format:
// <years to event>years;<months to event>months;<days to event>days-<event title>
//
// note that there are not white spaces here.
//
// if the date format is incorrect, the function should not include the string in output array.
//
// The code has one or more bugs. it your task to find the bugs and resolve the issues.
