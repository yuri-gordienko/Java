package yugo.test_SoftServe;

class Test {
    private int field;

    static {
//        field = 10;
    }

    public Test(int number) {
        field = number;
    }
}

    public class Q9 {
        public static void main(String[] args) {
            Test object = new Test(100);
//            System.out.println(object.field);
        }
    }

