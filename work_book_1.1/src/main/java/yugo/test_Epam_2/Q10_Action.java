package yugo.test_Epam_2;

public class Q10_Action {
    int calc(int n) {
        int result;
        if (n == 1) return 1;
        result = calc(n - 1) * n;
        return result;
    }
}

class Main {
    public static void main(String args[]) {
        Q10_Action action = new Q10_Action();
        System.out.println(action.calc(5));
    }
}
