package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String CUSTOMER_ID_REGEX="^KH-[0-9]{4}$";
    public static final String SERVICE_ID_REGEX="^DV-[0-9]{4}$";
    public static final String PHONE_REGEX="^090[0-9]{7}|091[0-9]{7}|(84)+90[0-9]{7}|(84)+91[0-9]{7}$";
    public static final String ID_CARD_REGEX="^[0-9]{9}$|^[0-9]{12}$";
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static String message=null;
    public static String validateCustomerID(String regex) {
        String CUSTOMER_ID_REGEX="^KH-[0-9]{4}$";
        if (!CUSTOMER_ID_REGEX.matches(regex)){
            message="Sai cmnr.KH-XXXX (X là số từ 0-9)";
        }
        return message;
    }
    public static String validateServiceID(String regex) {
        String SERVICE_ID_REGEX="^DV-[0-9]{4}$";
        if (!SERVICE_ID_REGEX.matches(regex)){
            message="Sai cmnr.DV-XXXX (X là số 0-9)";
        }
        return message;
    }
    public static String validatePhoneNumber(String regex) {
        String PHONE_REGEX="^090[0-9]{7}|091[0-9]{7}|(84)+90[0-9]{7}|(84)+91[0-9]{7}$";
        if (!PHONE_REGEX.matches(regex)){
            message="Sai cmnr.090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx";
        }
        return message;
    }
    public static String validateIDCard(String regex) {
        String ID_CARD_REGEX="^[0-9]{9}$|^[0-9]{12}$";
        if (!ID_CARD_REGEX.matches(regex)){
            message="Sai cmnr.XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)";
        }
        return message;
    }
    public static String validateEmail(String regex) {
        String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (!EMAIL_REGEX.matches(regex)){
            message="Sai cmnr.abc@gmail.com";
        }
        return message;
    }

}
