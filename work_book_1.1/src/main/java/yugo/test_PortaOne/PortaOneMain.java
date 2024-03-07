package yugo.test_PortaOne;

public class PortaOneMain {
    public static void main(String[] args) {
        System.out.println("PortaOneMain is running");

        FileReader fileReader = new FileReader();
        fileReader.initFile();

        Analytics analytics = new Analytics();
        analytics.getMaxNumber(fileReader.getNumbers());
        analytics.getMinNumber(fileReader.getNumbers());
    }
}
