package yugo.test_PortaOne;

public class PortOneMain {
    public static void main(String[] args) {
        System.out.println("PortOneMain is running");

        FileReader fileReader = new FileReader();
        fileReader.initFile();

        Analytics analytics = new Analytics();
        analytics.getMaxNumber(fileReader.getNumbers());
        analytics.getMinNumber(fileReader.getNumbers());
    }
}
