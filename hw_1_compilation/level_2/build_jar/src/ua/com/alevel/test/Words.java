package ua.com.alevel.test;

import org.apache.commons.lang3.StringUtils;
public class Words {
    public void printMessage(String sms) {
        System.out.println("this" + " " + sms);
        System.out.println("this" + " " + StringUtils.upperCase(sms));
    }
}

