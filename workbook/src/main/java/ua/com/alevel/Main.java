package ua.com.alevel;

public class Main {

    public static void main(String[] args) {

        String str = "1234";
        String str2 = "hello";
        String str3 = "Bob";
        String str4 = "";

//        String nS = String.valueOf(str.charAt((str.length()/2-1)) + "" + str.charAt(str.length()/2));
//        String nS3 = String.valueOf(str3.charAt(str3.length()/2));
//        String nS2 = String.valueOf(str2.charAt(str2.length()/2));
//        String nS4 = str4;

//        System.out.println(nS);
//        System.out.println(nS2);
//        System.out.println(nS3);
//        System.out.println("- " + nS4);

        String getMiddleString = getMiddleString(str);
        String getMiddleString1 = getMiddleString(str2);
        String getMiddleString2 = getMiddleString(str3);
        String getMiddleString3 = getMiddleString(str4);


    }
    public static String getMiddleString(String originalString) {

//        int middlestringValue = originalString.length()/2;
//        int stringLen = originalString.length();

        StringBuilder st = new StringBuilder();

        if (originalString.equals("") || originalString == null){
            System.out.println(originalString);
            return "";
        }
        for (char i = 0; i < originalString.length(); i++) {
            if (i % 2 ==0) {
                st.append(originalString.charAt(i));
            }
        }

        System.out.println(st);

        return st.toString();
    }



}


























