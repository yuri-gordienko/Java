package org.yg.Array_ifOrSwitch_Circle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Circle {

    public void test() throws IOException {
        byte[] ascii = new byte[128];
//        for (byte i = 0; i < 128; i = (byte) (i + 1)) {
//            System.out.println("i = " + i);
//            ascii[i] = i;
//            if (i == 127) {
//                break;
//            }
//        }
//        for (int i = 0; i < ascii.length; i++) {
//            System.out.println("index: " + i + ", symbol: " + (char) i);
//        }
//        for (byte b : ascii) {
//            System.out.println("index: " + b + ", symbol: " + (char) b);
//        }

        byte i = 0;
        while (i < 128) {
            ascii[i] = i;
            if (i == 127) {
                break;
            }
            i++;
        }

        for (byte b : ascii) {
            System.out.println("index: " + b + ", symbol: " + (char) b);
        }


//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("select your option");
//        String position;
//        try {
//            while ((position = reader.readLine()) != null) {
//                position = reader.readLine();
//                if (position.equals("0")) {
//                    System.exit(0);
//                }
//                runNavigation();
//            }
//        } catch (IOException e) {
//            System.out.println("problem: = " + e.getMessage());
//        }
//    }
//
//    private void runNavigation() {
//        System.out.println();
//        System.out.println("if you want create user, please enter 1");
//        System.out.println("if you want update user, please enter 2");
//        System.out.println("if you want delete user, please enter 3");
//        System.out.println("if you want findById user, please enter 4");
//        System.out.println("if you want findAll user, please enter 5");
//        System.out.println("if you want exit, please enter 0");
//        System.out.println();
//    }
        }
    }

