package yugo.test_Broscorp;

public class BroscorpMain {

    public static void main(String[] args) {

        String[] events = {
                "The first human in space 12-03-1961",
                "Event C 01-01-1903",
                "Event A 04-01-1900",
                "Event B 01-04-1900",
                "",
                "131313 12-12-1987",
                "E-11 11-12-1900"
        };

        String[] result = TestTakerCorrected3.sorted(events);
        for (String event : result) {
            System.out.print("\n" + event);
        }
    }
}
