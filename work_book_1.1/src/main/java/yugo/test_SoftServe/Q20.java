package yugo.test_SoftServe;

public class Q20 extends Parent {
    String str = "Chiel class";

    public String method() {
        return str;
    }

    public static void main(String[] args) {
        Parent parent = new Q20();
        System.out.println(parent.method());
        System.out.println(parent.str);
    }
}

class Parent {
    protected String str = "Parent class";

    public String method() {
        return str;
    }
}
