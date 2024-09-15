package yugo.test_Epam_1;

public class Q17_A {

    protected Number getValue() {

        return 1;
    }

    public static void main(String args[]) {
        Q17_A a[] = new Q17_A[] {new Q17_A(), new B()};
        for (Q17_A ob : a) System.out.print(ob.getValue());
    }
}

class B extends Q17_A {
    public Integer getValue() {

        return 2;
    }
}
