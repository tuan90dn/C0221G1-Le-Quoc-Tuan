package person.controller;

import person.model.Students;
import person.services.ServicesOfStudent;
import person.services.implement_services.ImplementServicesOfStudent;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    private ServicesOfStudent servicesOfStudent=new ImplementServicesOfStudent();
    private Scanner scanner=new Scanner(System.in);
    public void menuAdd(){
        while (true) {
            System.out.println("Bạn muốn thêm mới: ");
            System.out.println("1. Học sinh");
            System.out.println("2. Giáo viên");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            try {
                System.out.print("Mời bạn nhập lự chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Students student = servicesOfStudent.inputAddOrEdit();
                        servicesOfStudent.add(student);
                        return;
                    case 2:
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Bạn nhập lựa chon sai. Yêu cầu nhập lại!");
                }
            } catch (Exception e) {
                System.out.println("Bạn nhập lựa chon sai. Yêu cầu nhập lại!");
            }

        }
    }
    public void showListStudent(List<Students> students){
        System.out.println("List students: ");
        Students students1;
        for (int i=0;i<students.size();i++){
//            System.out.println((i+1)+"."+students.get(i));
            students1=students.get(i);
            students1.showInfor();
        }
    }
}
