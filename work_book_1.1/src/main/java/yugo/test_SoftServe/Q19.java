package yugo.test_SoftServe;

public class Q19 {
    public static void main(String[] args) {

        A a = new B(" success");
    }
}

    class A {
        public A() {
        System.out.println("Class A");
    }

        public A(String m) {

            System.out.println("Class A " + m);
        }
    }

    class B extends A {
        public B(String m) {

            System.out.println("Class B " + m);
        }
    }

