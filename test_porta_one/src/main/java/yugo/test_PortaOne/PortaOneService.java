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

        if (numbers.size() == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int maxNumber = numbers.get(0);

        for (int number : numbers) {
            if (maxNumber < number) {
                maxNumber = number;
            }
        }

        return maxNumber;
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

        double medianNumber;
        if (sortedList.size() % 2 != 0) {
            medianNumber = sortedList.get(sortedList.size() / 2);
        } else {
            medianNumber = (sortedList.get(sortedList.size() / 2 - 1) + sortedList.get(sortedList.size() / 2)) / 2.0;
        }

        return medianNumber;
    }

    //  4. Average number
    public static double getAverageNumber(List<Integer> numbers) {

        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        double averageNumber = 0;
        for (int number : numbers) {
            averageNumber += (double) number / numbers.size();
        }

        return averageNumber;
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
