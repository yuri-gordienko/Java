package yugo.test_Epam_1;

public class Q10_Rec {

    int recursion(int n) {
        if (n == 1)
            return 1;
        return recursion(n - 1);
    }
}

class MainQuest {
    public static void main(String args[]) {
        Q10_Rec rec = new Q10_Rec();
        System.out.print(rec.recursion(6));
    }
}