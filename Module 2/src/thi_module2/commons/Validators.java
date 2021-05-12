package thi_module2.commons;

import furuma_resort.exceptions.*;
import thi_module2.exceptions.*;

import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {

    public static final String SODIENTHOAI_REGEX="[0][\\d]{9}";
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


    public static void isValidFullName(String fullName) throws TenException {
        String[] fullNameElements=fullName.split(" ");
        for (String element: fullNameElements){
            if (Character.isLowerCase(element.charAt(0))){
                throw new TenException();
            }
            for (int i=1;i<element.length();i++){
                if (Character.isUpperCase(element.charAt(i))){
                    throw new TenException();
                }
            }
        }
        for (int i=0;i<fullName.length()-1;i++){
            if (fullName.charAt(i)== ' '&&fullName.charAt(i+1)==' '){
                throw new TenException();
            }
        }
    }
    public static void isValidEmail(String email) throws EmailExceptions {
        if (email.indexOf("@")<0){
            throw new EmailExceptions();
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
                throw new EmailExceptions();
            }
        }
        if (countPoint==0){
            throw new EmailExceptions();
        }
    }
    public static void isValidGender(String gender) throws GioiTinhException {
        String[] listCheck={"male","female","unknown"};
        if (!Arrays.asList(listCheck).contains(gender.toLowerCase())){
            throw new GioiTinhException();
        }
    }
    public static void isSoDienThoai(String soDienThoai) throws SoDienThoaiException {
        if (!isValidRegex(soDienThoai, Validators.SODIENTHOAI_REGEX)){
            throw new SoDienThoaiException();
        }
    }
    public static void isValidBirthday(String birthday) throws BirthdaysException {
        if (isValidRegex(birthday, furuma_resort.commons.Validator.BIRTHDAY_REGEX)){
            int year=Integer.parseInt(birthday.split("/")[2]);
            int currentYear= Year.now().getValue();
            if (year<=1900||currentYear-year<18){
                throw new BirthdaysException();
            }
        } else {
            throw new BirthdaysException();
        }
    }
}
