package ua.com.alevel;

public class Main {

    public static void main(String[] args) {

        try {
            bm();
            System.out.println("A");
        } catch(RuntimeException ex) {
            System.out.println("B");
        } catch(Exception ex1) {
            System.out.println("c");
        } finally {
            System.out.println("d");
        }
        System.out.println("e");
    }
    public static void bm() {
        throw new RuntimeException();
//        System.out.println("met");
    }




}

























