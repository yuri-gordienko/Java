package yugo.test_PortaOne;

import java.util.List;

public class PortaOneMain {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        PortaOneService portaOneService = new PortaOneService();

        fileReader.initFile();

        int maxNumber = portaOneService.getMaxNumber(fileReader.getNumbers());
        System.out.println("maxNumber = " + maxNumber);

        int minNumber = portaOneService.getMinNumber(fileReader.getNumbers());
        System.out.println("minNumber = " + minNumber);

        double medianNumber = portaOneService.getMedianNumber(fileReader.getNumbers());
        System.out.println("medianNumber = " + medianNumber);

        double averageNumber = portaOneService.getAverageNumber(fileReader.getNumbers());
        System.out.println("averageNumber = " + averageNumber);

        List<Integer> longestIncreasingSequence = portaOneService.findLongestIncreasingSequence(fileReader.getNumbers());
        System.out.println("longestIncreasingSequence = " + longestIncreasingSequence);

        List<Integer> longestDecreasingSequence = portaOneService.findLongestDecreasingSequence(fileReader.getNumbers());
        System.out.println("longestDecreasingSequence = " + longestDecreasingSequence);
    }
}
