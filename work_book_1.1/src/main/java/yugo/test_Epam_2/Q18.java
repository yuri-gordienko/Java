package yugo.test_Epam_2;

public class Q18 {

        public static void main(String[] args) {
            int j = 10;
            try {
                int i = doIt() / (j = 20);
            } catch (Exception e) {
                System.out.print(j);
            }
        }

        public static int doIt() throws Exception {
            throw new Exception("E");
        }
    }

