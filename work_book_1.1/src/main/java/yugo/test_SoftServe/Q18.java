package yugo.test_SoftServe;

public class Q18 {

    public static void main(String[] args) {
       new Child();
    }

//    static class Parent {
//        void display() {
//            System.out.println("Parent class");
//        }
//    }
//
//    static class Child extends Parent {
//        void show() {
//            super.display(); // Using 'super' to refer to the parent class method
//        }
//    }
//----------------------------
    static class Parent {
        Parent() {
            System.out.println("Parent class constructor");
        }
    }

    static class Child extends Parent {
        Child() {
            super(); // This must be the first statement in the child class constructor
            System.out.println("Child class constructor");
        }
    }
}
