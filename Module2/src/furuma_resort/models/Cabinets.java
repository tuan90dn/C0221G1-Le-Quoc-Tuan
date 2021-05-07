package furuma_resort.models;

import furuma_resort.controllers.MainController;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Cabinets {

    private static Stack<Employee> stackOfEmployee=new Stack<>();
    static {
        Map<String,Employee> mapOfEmployee= MainController.readEmployee(MainController.EMPLOYEE);
        for (Map.Entry<String,Employee> entry:mapOfEmployee.entrySet()){
            stackOfEmployee.push(entry.getValue());
        }
    }


    private static Employee getFileEmployee(String id){
        Employee employee=null;
        while (!stackOfEmployee.isEmpty()){
            employee=stackOfEmployee.pop();
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return employee;
    }
    public static void findEmployee(){
//        MainController.showInformationOfEmployee();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please input the id of employee need do search: ");
        String id=scanner.nextLine();
        Employee employee1=getFileEmployee(id);
        if (employee1 !=null){
            System.out.println("Employee is: "+employee1.toString());
        } else {
            System.out.println("Not found!");
        }
        employee1=null;
    }
}
