package yugo.test_Andersen;

public class AndersenMain {

    public static void main(String[] args) {
//        ChangeInteger changeInteger = new ChangeInteger();
//        Integer value = 1;
//        changeInteger.change(value);
//        System.out.println(value);

//        Test t1 = new Test();
//        ThreadsDemo t2 = new ThreadsDemo();
//        t1.start();
//        t2.start();

//        Thread t = new Test2() {
//            public void run() {
//                System.out.println(" foo");
//            }
//        };
//        t.start();

        new Thread(new Test3()).start();
    }
}
