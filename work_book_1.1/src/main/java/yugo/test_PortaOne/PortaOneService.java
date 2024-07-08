package yugo.test_PortaOne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PortaOneService {

    private FileReader fileReader = new FileReader();
    private List<Integer> numbers = fileReader.getNumbers();


    //  1. Max number
    public Integer getMaxNumber(List<Integer> numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }

        return numbers.stream().max(Integer::compareTo).orElseThrow(() ->
                new IllegalArgumentException("Array is empty"));
    }

    //  2. Min number
    public Integer getMinNumber(List<Integer> numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }

        return numbers.stream().min(Integer::compareTo).orElseThrow(() ->
                new IllegalArgumentException("Array is empty"));
    }

    //  3. Median number
    public static double getMedianNumber(List<Integer> numbers) {

        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException("List is null or empty");
        }

        List<Integer> sortedList = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        int listSize = sortedList.size();
        return listSize % 2 != 0
                ? sortedList.get(listSize / 2)
                : (sortedList.get(listSize / 2 - 1) + sortedList.get(listSize / 2)) / 2.0;
    }

    //  4. Average number
    public static double getAverageNumber(List<Integer> numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }

        return numbers.stream().mapToInt(Integer::intValue).average().orElseThrow(() ->
                new IllegalArgumentException("Array is empty"));
    }

    //  5. longestIncreasingSequence
    public List<Integer> findLongestIncreasingSequence(List<Integer> numbers) {

        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException("List is null or empty");
        }

        int maxLength = 1;
        int startIndex = 0;
        int currentLength = 1;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = i - maxLength + 1;
                }
            } else {
                currentLength = 1;
            }
        }

        List<Integer> result = new ArrayList<>(numbers.subList(startIndex, startIndex + maxLength));
        return result;
    }

    //  6. longestDecreasingSequence
    public List<Integer> findLongestDecreasingSequence(List<Integer> numbers) {

        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException("List is null or empty");
        }

        int maxLength = 1;
        int startIndex = 0;
        int currentLength = 1;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i - 1)) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = i - maxLength + 1;
                }
            } else {
                currentLength = 1;
            }
        }

        List<Integer> result = new ArrayList<>(numbers.subList(startIndex, startIndex + maxLength));
        return result;
    }
}
