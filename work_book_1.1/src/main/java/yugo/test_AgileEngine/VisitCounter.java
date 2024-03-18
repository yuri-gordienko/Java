package yugo.test_AgileEngine;

import java.util.*;
import java.util.stream.Collectors;

public class VisitCounter {

    public Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null || visits.length == 0) {
            return Collections.emptyMap(); // Return an empty map for null or empty input
        }

        return Arrays.stream(visits)
                .filter(Objects::nonNull) // Filter out null maps
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> isValidEntry(entry.getKey(), entry.getValue()))
                .collect(Collectors.groupingBy(
                        entry -> Long.parseLong(entry.getKey()),
                        Collectors.summingLong(entry -> entry.getValue().getVisitCount().orElse(0L))
                ));
    }

    private boolean isValidEntry(String key, UserStats userStats) {
        try {
            long userId = Long.parseLong(key);
            return userStats != null && userStats.getVisitCount().isPresent();
        } catch (NumberFormatException e) {
            return false; // Skip faulty entries with non-representable keys
        }
    }

    public static void main(String[] args) {
        // Приклад використання
        UserStats userStats1 = new UserStats(5L);
        UserStats userStats2 = new UserStats(10L);

        VisitCounter visitCounter = new VisitCounter();
        Map<Long, Long> result = visitCounter.count(
                Map.of("user1", userStats1),
                Map.of("user2", userStats2)
        );

        System.out.println(result);
    }
}