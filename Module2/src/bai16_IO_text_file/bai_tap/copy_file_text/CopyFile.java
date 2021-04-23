package bai16_IO_text_file.bai_tap.copy_file_text;

import bai16_IO_text_file.thuc_hanh.ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }
    public void writeFile(String filePath,List<Integer> numbers){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Nội dung sao chép là: " + numbers);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {//
        CopyFile copyFile=new CopyFile();
        List<Integer> numbers = copyFile.readFile("tuan.txt");//
        copyFile.writeFile("copy.txt", numbers);
    }
}
