package yugo.test_Broscorp;

public class TestTakerCorrected2 {

    public static String[] sorted(String[] events) {

        final java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final java.time.LocalDate now = java.time.LocalDate.of(1900, 1, 1);

        java.util.List<String> listOfEvents = new java.util.ArrayList<>();
        for (String event : events) {
            java.util.Optional<java.time.LocalDate> date = findDateInLine(event, formatter);
            if (date.isEmpty()) continue;
            java.time.Period timeLeft = java.time.Period.between(now, date.get());

            int dateIndex = event.indexOf(date.get().format(formatter));
            String title = event.substring(dateIndex + 11).trim();
            StringBuilder sb = new StringBuilder();
            sb.append(timeLeft.getYears()).append("years;")
                    .append(timeLeft.getMonths()).append("months;")
                    .append(timeLeft.getDays()).append("days-").append(title);
            listOfEvents.add(sb.toString());
        }
        listOfEvents.sort((e1, e2) -> e1.compareTo(e2));

        return listOfEvents.toArray(new String[0]);
    }

    private static java.util.Optional<java.time.LocalDate> findDateInLine(String line,
                                                                          java.time.format.DateTimeFormatter formatter) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
        if (m.find()) {
            return java.util.Optional.of(java.time.LocalDate.parse(m.group(), formatter));
        }
        return java.util.Optional.empty();
    }
}
