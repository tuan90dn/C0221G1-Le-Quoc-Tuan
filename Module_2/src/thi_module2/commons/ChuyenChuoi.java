package thi_module2.commons;

public class ChuyenChuoi {
    public static String chuyenChuoi(String string){
        StringBuilder stringBuilder=new StringBuilder(string.substring(0,1).toUpperCase());
        stringBuilder.append(string.substring(1).toLowerCase());
        return stringBuilder.toString();
    }
}
