package ua.com.alevel;


import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    makeAbbr("national aeronautics space administration");
// "NASA"

    }

    public static String makeAbbr(String fullName) {
//        System.out.println(fullName);

        String[] split = fullName.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String string : split) {
            builder.append(string.toUpperCase().charAt(0));
        }
        System.out.println(builder);
        return builder.toString();

    }





}


























