package ua.com.alevel;

import java.text.DecimalFormat;
public class School {
    public void lesson(int ln) {
        DecimalFormat dF = new DecimalFormat("#.###");

        int h = 60;             // 1 hour = 60 min
        int l = 45;             // lesson time 45 min
        int b1 = 5;             // break of even lessons
        int b2 = 15;            // break of not even lessons
        int s = h * 9;          // start of lesson 1
        int e = ln - 1;          // number of lesson

        int elh = (s + (e * b1) + ((e / 2) * ((b1 + b2) / 2)) + (ln * l)) / h;
        String sto = Integer.toString(elh);
        int elm = (s + (e * b1) + ((e / 2) * ((b1 + b2) / 2)) + (ln * l)) % h;
        String str = Integer.toString(elm);

        System.out.println("End of lesson # " + ln + " is: " + new DecimalFormat("00.###").format(elh) + ":" + new DecimalFormat("00.###").format(elm));
    }
}