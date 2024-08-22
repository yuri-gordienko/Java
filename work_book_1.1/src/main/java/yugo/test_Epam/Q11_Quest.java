package yugo.test_Epam;

public class Q11_Quest {

    public static void main(String[] args) {
        int x = 7;
        IntObject intObject = new IntObject();
        intObject.number = 7;
        IntObject.bump(x, intObject);
        System.out.print(x + " " + intObject.number);
    }
}

class IntObject {
    public int number;

    public static void bump(int n, IntObject ob) {
        n++;
        ob.number++;
    }
}
