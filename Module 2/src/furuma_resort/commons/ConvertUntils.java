package furuma_resort.commons;

public class ConvertUntils {
    public static String convertGender(String string){
        StringBuilder stringBuilder=new StringBuilder(string.substring(0,1).toUpperCase());
        stringBuilder.append(string.substring(1).toLowerCase());
        return stringBuilder.toString();
    }
}
