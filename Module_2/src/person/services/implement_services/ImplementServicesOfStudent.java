package person.services.implement_services;

import person.model.Students;
import person.services.ServicesOfPerson;
import person.services.ServicesOfStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImplementServicesOfStudent implements ServicesOfStudent {
    private static final String PERSON = "D:\\C0221G1-Le-Quoc-Tuan\\Module2\\src\\person\\data\\person.csv";
    Scanner scanner=new Scanner(System.in);

    @Override
    public boolean add(Students students) {
        try {//
            FileWriter fileWriter=new FileWriter(PERSON,true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(students.toString());
            bufferedWriter.close();
            System.out.println("Add new student is done!");
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Students students, int index) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public List<Students> list() {
        List<Students> listStudent=new ArrayList<>();
        try {
            FileReader reader=new FileReader(PERSON);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arrayStudent=line.split(",");
                if (arrayStudent.length==5){
                    listStudent.add(new Students(arrayStudent[0],Integer.parseInt(arrayStudent[1]),
                            arrayStudent[2],arrayStudent[3],Double.parseDouble(arrayStudent[4])));
                }
            }
            bufferedReader.close();
            return listStudent;
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error reading from file!");
        }
        return null;
    }

    @Override
    public Students inputAddOrEdit() {
        System.out.print("Mời bạn nhập tên của sinh viên: ");
        String name = this.scanner.nextLine();
        System.out.print("Mời bạn nhập tuổi của sinh viên: ");
        int age = Integer.parseInt(this.scanner.nextLine());
        System.out.print("Mời bạn nhập địa chỉ của sinh viên: ");
        String address = this.scanner.nextLine();
        System.out.print("Mời bạn nhập lớp của sinh viên: ");
        String classStudent = this.scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của sinh viên: ");
        double point = Double.parseDouble(this.scanner.nextLine());
        Students student = new Students(name, age, address, classStudent, point);
        return student;
    }

}
