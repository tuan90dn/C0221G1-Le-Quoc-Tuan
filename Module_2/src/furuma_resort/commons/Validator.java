package furuma_resort.commons;

import furuma_resort.exceptions.*;

import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String SERVICE_ID_REGEX="SV(VL|HO|RO)-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX="[A-Z][a-z]*";
    public static final String ID_CARD_REGEX="[\\d]{3} [\\d]{3} [\\d]{3}";
    public static final String BIRTHDAY_REGEX="[\\d]{2}/[\\d]{2}/[\\d]{4}";
    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean isValidRegex(String string, String regex){
        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(string);
        boolean flag=matcher.matches();
        if (!flag){
            System.out.println("Input not matching "+regex+" Please input again: ");
        }
        return flag;
    }
    public static boolean isMoreThan(double number, double numberRegex){
        boolean flag=number>numberRegex;
        if (!flag){
            System.out.println("Please input more than: "+numberRegex);
        }
        return flag;
    }
    public static boolean isMoreThan(double number, double firstNumber,double secondNumber){
        boolean flag=number>firstNumber&&number<secondNumber;
        if (!flag){
            System.out.println("Please input more than: "+firstNumber+" and less than "+secondNumber);
        }
        return flag;
    }
    public static boolean isValidExtraService(String extraServiceName){
        String[] listService={"massage","karaoke", "food", "drink"," car"};
        boolean flag= Arrays.asList(listService).contains(extraServiceName);
        if (!flag){
            System.out.println("Please input: massage, karaoke, food, drink, car. ");
        }
        return flag;
    }
    public static void isValidFullName(String fullName) throws NameException {
        String[] fullNameElements=fullName.split(" ");
        for (String element: fullNameElements){
            if (Character.isLowerCase(element.charAt(0))){
                throw new NameException();
            }
            for (int i=1;i<element.length();i++){
                if (Character.isUpperCase(element.charAt(i))){
                    throw new NameException();
                }
            }
        }
        for (int i=0;i<fullName.length()-1;i++){
            if (fullName.charAt(i)== ' '&&fullName.charAt(i+1)==' '){
                throw new NameException();
            }
        }
    }
    public static void isValidEmail(String email) throws EmailException {
        if (email.indexOf("@")<0){
            throw new EmailException();
        }
        int countA=0;
        int countPoint=0;
        for (int i=0;i<email.length();i++){
            if (email.charAt(i)== '@'){
                countA++;
            }else if (email.charAt(i)=='.'){
                countPoint++;
            }
            if (countA>=2){
                throw new EmailException();
            }
        }
        if (countPoint==0){
            throw new EmailException();
        }
    }
    public static void isValidGender(String gender) throws GenderException {
        String[] listCheck={"male","female","unknown"};
        if (!Arrays.asList(listCheck).contains(gender.toLowerCase())){
            throw new GenderException();
        }
    }
    public static void isValidIdCard(String idCard) throws IdCardException {
        if (!isValidRegex(idCard,Validator.ID_CARD_REGEX)){
            throw new IdCardException();
        }
    }
    public static void isValidBirthday(String birthday) throws BirthdayException {
        if (isValidRegex(birthday,Validator.BIRTHDAY_REGEX)){
            int year=Integer.parseInt(birthday.split("/")[2]);
            int currentYear= Year.now().getValue();
            if (year<=1900||currentYear-year<18){
                throw new BirthdayException();
            }
        } else {
            throw new BirthdayException();
        }
    }

}
