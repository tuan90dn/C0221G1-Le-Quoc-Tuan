package thi_module2.commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    public static String path;
    public static void writeFile(String[] content){
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path,true));
            bufferedWriter.write(StringUtil.concat(content, StringUtil.COMMA));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(){
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path,false));
            bufferedWriter.write("");
//            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFile(){
        List<String> arrayContent=new ArrayList<>();
        try {
            bufferedReader=new BufferedReader(new FileReader(path));
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                arrayContent.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayContent;
    }
    public static void setPath(String fileName){
        StringBuffer path=new StringBuffer("D:\\C0221G1-Le-Quoc-Tuan\\Module2\\src\\thi_module2\\data\\");
        path.append(fileName);
        path.append(StringUtil.CSV);
        FileUtil.path=path.toString();
    }
}
