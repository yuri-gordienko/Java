package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

public class ServiceLib {

    public static String specifiedRevers(String text, String dest) {
        String result = "";
        int index = text.indexOf(dest);
        if (index > 0) {
            String specifRevers = StringUtils.reverse(dest);
            result = text.replace(dest, specifRevers);
            return result;
        }
        return "false letters range";
    }

    public static String reverseBiIndexes(String string, int firstIndex, int lastIndex) {
        String indexReverse = "";
        String substring = string.substring(firstIndex, lastIndex + 1);
        String[] words = substring.split(" ");
        for (int i = 0; i < words.length; i++) {
            indexReverse = (indexReverse + " " + StringUtils.reverse(words[i])).trim();
        }
        return string.replace(substring, indexReverse);
    }
}

