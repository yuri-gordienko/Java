package yugo.test_SoftServe;

public class Q20 extends Parent {
//    String str = "Chiel class";
//    public String method() {
//        return str;
//    }

    // Valid: Less restrictive (more permissive)
    public void doSomething() {
        super.doSomething();
        System.out.println("Subclass: Doing something");
    }


    public static void main(String[] args) {
//        Parent parent = new Q20();
//        System.out.println(parent.method());
//        System.out.println(parent.str);

        Parent parent = new Q20();
        parent.doSomething();
    }
}

class Parent {
//    protected String str = "Parent class";
//    public String method() {
//        return str;
//    }

    protected void doSomething() {
        System.out.println("Superclass: Doing something");
    }
}
