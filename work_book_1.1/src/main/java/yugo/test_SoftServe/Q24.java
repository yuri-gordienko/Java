package yugo.test_SoftServe;

public class Q24 {

    public static void main(String[] args) {

        try {
            throw new Example();
        } catch (Example e) {
            System.out.println("hello ");
        }
        System.out.println("world");
    }
}

class Example extends Exception { }
