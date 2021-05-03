package furuma_resort.commons;

public class StringUtils {
    public static final String COMMA ="," ;
    public static final String CSV = ".csv";

    public static String concat(String[] content, String comma) {
        StringBuffer outString=new StringBuffer(content[0]);
        for (int i=1;i<content.length;i++){
            outString.append(comma);
            outString.append(content[i]);
        }
        return outString.toString();
    }
}
