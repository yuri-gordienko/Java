package ua.com.alevel.Tasks;

public class Main {

    public static void main(String[] args){

        int rait = reviewCode(10);
        System.out.println(rait);

    }

    public static int reviewCode(int maxAttempts) {
        int solutionAttempts = 0;

        do {
            solutionAttempts++;
        } while (solutionAttempts < maxAttempts);
        return solutionAttempts;
    }


}
