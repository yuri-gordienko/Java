package yugo.test_Epam_1;

public class Q33 {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        System.out.println("builder = " + builder);

        builder.append("java19");
        System.out.println("builder append = " + builder);

        builder.subSequence(3, 6);
        System.out.println("builder subSequence = " + builder);

        String resultString = builder.subSequence(3, 6).toString();
        System.out.println("resultString = " + resultString);

        System.out.print(builder);
    }
}
