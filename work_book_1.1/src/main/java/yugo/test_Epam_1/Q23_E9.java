package yugo.test_Epam_1;

public class Q23_E9 {

    public static void main(String[] args) {
        try {
            double[] d = {0, Double.NaN / 0, 1};
            d[-1] = -1;
        } catch (ArithmeticException e) {
            System.out.print("A ");
        } catch (NullPointerException e) {
            System.out.print("N ");
        } catch (IndexOutOfBoundsException e) {
            System.out.print("I ");
        } catch (RuntimeException e) {
            System.out.print("R ");
        } catch (Exception e) {
            System.out.print("E ");
        }
    }
}
