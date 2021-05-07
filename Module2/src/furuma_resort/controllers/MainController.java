package furuma_resort.controllers;

import furuma_resort.commons.ConvertUntils;
import furuma_resort.commons.FileUtils;
import furuma_resort.commons.StringUtils;
import furuma_resort.commons.Validator;
import furuma_resort.exceptions.*;
import furuma_resort.models.*;

import java.util.*;

public class MainController {

    private static Scanner scanner=new Scanner(System.in);
    private static String VILLA="villa";
    private static String HOUSE="house";
    private static String ROOM="room";
    private static String CUSTOMER="customer";
    private static String BOOKING = "booking";
    public static String EMPLOYEE = "employee";
    public static void displayMainMenu(){
        int choose=-1;
        do {
            System.out.println("1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tShow Queue of Employee\n"+
                    "8.\tShow Stack of Employee\n"+
                    "9.\tExit");
            System.out.println("Input your choice: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addNewServies();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(CUSTOMER);
                    break;
                case 4:
                    showInformationOfCustomer(CUSTOMER);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 7:
                    showQueueOfCustomer();
                    break;
                case 8:
                    showStackOfCustomer();


            }

        }while (choose != 9);
    }

    private static void showStackOfCustomer() {
        Cabinets.findEmployee();
    }

    private static void showQueueOfCustomer() {
        Queue<Customer> queueCustomer=new LinkedList<>();
        List<Customer> listOfCustomers=readCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        queueCustomer.add(listOfCustomers.get(0));
        queueCustomer.add(listOfCustomers.get(1));
        queueCustomer.add(listOfCustomers.get(2));
        Customer customer=null;
        System.out.println("List customer who buy ticket: ");
        while (!queueCustomer.isEmpty()){
            customer=queueCustomer.poll();
            customer.showInfor();
        }
    }
    public static Map<String,Employee> readEmployee(String fileName){
        FileUtils.setPath(fileName);
        List<String> listPropertiesOfEmployee=FileUtils.readFile();
        Map<String,Employee> mapEmployee=new HashMap<>();
        String[] arrayPropertiesOfEmployee=null;
        Employee employee=null;
        for (String property:listPropertiesOfEmployee){
            arrayPropertiesOfEmployee=property.split(StringUtils.COMMA);
            employee=new Employee();
            employee.setId(arrayPropertiesOfEmployee[0]);
            employee.setNameOfEmployee(arrayPropertiesOfEmployee[1]);
            employee.setBirthday(arrayPropertiesOfEmployee[2]);
            employee.setAddress(arrayPropertiesOfEmployee[3]);
            mapEmployee.put(employee.getId(),employee);
        }
        return mapEmployee;

    }

    private static void showInformationOfEmployee() {
        Map<String,Employee> mapEmployee=readEmployee(EMPLOYEE);
        System.out.println("List employee");
        for (Map.Entry<String,Employee> employeeEntry:mapEmployee.entrySet()){
            System.out.println(employeeEntry.getKey()+" "+employeeEntry.getValue().toString());
        }
    }

    private static void addNewBooking() {
        List<Customer> listReadCustomer=readCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Please choose customer to booking: ");
        int chooseCustomer=Integer.parseInt(scanner.nextLine());

            System.out.println("1.\tBooking Villa\n" +
                    "2.\tBooking House\n" +
                    "3.\tBooking Room\n"+
                    "4.\tExit.");
            System.out.println("Input your choice: ");
        int chooseModel=Integer.parseInt(scanner.nextLine());
        List<Services> listOfService=null;
        switch (chooseModel){
            case 1:
                listOfService=readService(VILLA);
                showAllServices(VILLA);
                break;
            case 2:
                listOfService=readService(HOUSE);
                showAllServices(HOUSE);
                break;
            case 3:
                listOfService=readService(ROOM);
                showAllServices(ROOM);
                break;
        }
        System.out.println("Please choose service to booking: ");
        int chooseService=Integer.parseInt(scanner.nextLine());
        Customer customer=listReadCustomer.get(chooseCustomer-1);
        customer.setServices(listOfService.get(chooseService-1));
        FileUtils.setPath(BOOKING);
        FileUtils.writeFile(new String[]{customer.toString()});


    }
    private static List<Customer> readCustomer(String fileName){
        FileUtils.setPath(fileName);
        List<String> arrayReadCustomer=FileUtils.readFile();
        List<Customer> listCustomer=new ArrayList<>();
        String[] propertiesCustomer=null;
        Customer customer=null;
        for (String property: arrayReadCustomer){
            propertiesCustomer=property.split(StringUtils.COMMA);
            customer=new Customer();
            customer.setFullName(propertiesCustomer[0]);
            customer.setBirthday(propertiesCustomer[1]);
            customer.setGender(propertiesCustomer[2]);
            customer.setIdCard(propertiesCustomer[3]);
            customer.setPhoneNumber(propertiesCustomer[4]);
            customer.setEmail(propertiesCustomer[5]);
            customer.setTypeOfCustomer(propertiesCustomer[6]);
            customer.setAddress(propertiesCustomer[7]);
            listCustomer.add(customer);
        }
        Collections.sort(listCustomer);
        return listCustomer;
    }

    private static void showInformationOfCustomer(String fileName) {
        System.out.println("List customer: ");
        List<Customer> listCustomer=readCustomer(fileName);

        int i;
        Customer customer=null;
        for (i=0;i<listCustomer.size();i++){
            customer=listCustomer.get(i);
            System.out.print((i+1)+".");
            customer.showInfor();
        }
    }

    private static void addNewCustomer(String fileName) {
        boolean flag;
        String fullName=null;
        do {
            flag=true;
            System.out.println("Please input full name: ");
            fullName=scanner.nextLine();
            try {
                Validator.isValidFullName(fullName);
            } catch (NameException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);
        String birthday=null;
        do {
            flag=true;
            System.out.println("Please input birthday: ");
            birthday=scanner.nextLine();
            try {
                Validator.isValidBirthday(birthday);
            } catch (BirthdayException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);


        String gender=null;
        do {
            flag=true;
            System.out.println("Please input gender: ");
            gender= ConvertUntils.convertGender(scanner.nextLine());
            try {
                Validator.isValidGender(gender);
            } catch (GenderException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);
        String idCard=null;
        do {
            flag=true;
            System.out.println("Please input id card: ");
            idCard=scanner.nextLine();
            try {
                Validator.isValidIdCard(idCard);
            } catch (IdCardException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);


        System.out.println("Please input phone numbers: ");
        String phoneNumber=scanner.nextLine();
        String email=null;
        do {
            flag=true;
            System.out.println("Please input email: ");
            email=scanner.nextLine();
            try {
                Validator.isValidEmail(email);
            } catch (EmailException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);

        System.out.println("Please input type of customer: ");
        String typeOfCustomer=scanner.nextLine();
        System.out.println("Please input address: ");
        String address=scanner.nextLine();
        FileUtils.setPath(fileName);
        FileUtils.writeFile(new String[]{fullName,birthday,gender,idCard,phoneNumber,email,typeOfCustomer,address});
    }

    private static void showServices() {
        int choose=-1;
        while (choose!=8){
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Room Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println("Input your choice: ");
            choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    showAllServices(VILLA);
                    break;
                case 2:
                    showAllServices(HOUSE);
                    break;
                case 3:
                    showAllServices(ROOM);
                    break;
                case 4:
                    showAllServicesNotDuplicate(VILLA);
                    break;
                case 5:
                    showAllServicesNotDuplicate(HOUSE);
                    break;
                case 6:
                    showAllServicesNotDuplicate(ROOM);
                    break;
                case 7:
                    displayMainMenu();
                    break;
            }
        }

    }
    public static List<Services> readService(String fileName){
        FileUtils.setPath(fileName);
        List<String> resultReadFile=FileUtils.readFile();
        List<Services> listService=new ArrayList<>();
        Services services=null;
        ExtraServices extraServices=null;
        String[] propertyArray=null;
        for (String property:resultReadFile){
            propertyArray=property.split(StringUtils.COMMA);
            if (fileName.equals(VILLA)){
                services=new Villa();
                ((Villa)services).setStandardOfRoom(propertyArray[6]);
                ((Villa)services).setDifferentServices(propertyArray[7]);
                ((Villa)services).setAreaOfPool(Double.parseDouble(propertyArray[8]));
                ((Villa)services).setAmountOfFloor(Integer.parseInt(propertyArray[9]));
            } else if (fileName.equals(HOUSE)){
                services=new House();
                ((House)services).setStandardOfRoom(propertyArray[6]);
                ((House)services).setDifferentServices(propertyArray[7]);
                ((House)services).setAmountOfFloor(Integer.parseInt(propertyArray[8]));
            } else if (fileName.equals(ROOM)){
                extraServices=new ExtraServices(propertyArray[6],propertyArray[7],
                        Double.parseDouble(propertyArray[8]));
                services=new Room();
                ((Room)services).setFreeServices(extraServices);
            }
            services.setId(propertyArray[0]);
            services.setAreaOfEmploy(Double.parseDouble(propertyArray[2]));
            services.setPriceOfRent(Double.parseDouble(propertyArray[3]));
            services.setMaximumOfPerson(Integer.parseInt(propertyArray[4]));
            services.setTypeOfEmploy(propertyArray[5]);
            services.setNameOfService(propertyArray[1]);
            listService.add(services);
        }
        return listService;
    }

    private static void showAllServicesNotDuplicate(String fileName) {
        Set<String> setServices=new TreeSet<>();
        System.out.println("List services not duplicate: ");
        for (Services services:readService(fileName)){
            setServices.add(services.getNameOfService());
        }
        for (String services:setServices){
            System.out.println(services);;
        }
    }

    private static void showAllServices(String fileName) {
        System.out.println("List services: ");
        int i;
        List<Services> listReadService=readService(fileName);
        Services services=null;
        for (i=0;i<listReadService.size();i++){
            services=listReadService.get(i);
            System.out.print((i+1)+".");
            services.showInfor();
        }
    }
//    private static void showAllServices(String fileName) {
//        System.out.println("List services: ");
//        for (Services services:readService(fileName)){
//            services.showInfor();
//        }
//
//    }

    public static void addNewServies(){
        int choose=-1;
        while (choose!=5){
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit");
            System.out.println("Input your choice: ");
            choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    addNewService(VILLA);
                    break;
                case 2:
                    addNewService(HOUSE);
                    break;
                case 3:
                    addNewService(ROOM);
                    break;
                case 4:
                    displayMainMenu();
                    break;

            }
        }

    }
    private static void addNewService(String fileName) {
        String id=null;
        String nameService=null;
        double areaEmploy=0;
        double areaPool=0;
        double price=0;
        int maximum=0;
        int amountFloor=0;
        String nameExtraService=null;
        String type=null;
        String standard=null;
        do {
            System.out.println("Please input service's id: ");
            id=scanner.nextLine();
        }while (!Validator.isValidRegex(id,Validator.SERVICE_ID_REGEX));
        do {
            System.out.println("Please input service's name: ");
            nameService=scanner.nextLine();
        }while (!Validator.isValidRegex(nameService,Validator.SERVICE_NAME_REGEX));
        do {
            System.out.println("Please input area of employ: ");
            areaEmploy=Double.parseDouble(scanner.nextLine());
        }while (!Validator.isMoreThan(areaEmploy,30));
        do {
            System.out.println("Please input price of rent: ");
            price=Double.parseDouble(scanner.nextLine());
        }while (!Validator.isMoreThan(price,0));
        do {
            System.out.println("Please input maximum of person:");
            maximum=Integer.parseInt(scanner.nextLine());
        }while (!Validator.isMoreThan(maximum,0,20));
        do {
            System.out.println("Please input type of employ: ");
            type=scanner.nextLine();
        }while (!Validator.isValidRegex(type,Validator.SERVICE_NAME_REGEX));

        FileUtils.setPath(fileName);
        if (fileName.equals(VILLA)){
            do {
                System.out.println("Please input standard of room: ");
                standard=scanner.nextLine();
            }while (!Validator.isValidRegex(standard,Validator.SERVICE_NAME_REGEX));

            do {
                System.out.println("Please input area of pool: ");
                areaPool=Double.parseDouble(scanner.nextLine());
            }while (!Validator.isMoreThan(areaPool,30));
            do {
                System.out.println("Please input amount of floor: ");
                amountFloor=Integer.parseInt(scanner.nextLine());
            }while (!Validator.isMoreThan(amountFloor,0));

            System.out.println("Please input different services:");
            String differentService=scanner.nextLine();
//            String[] service = {id,nameService, String.valueOf(areaEmploy),
//                    String.valueOf(price), String.valueOf(maximum),type,standard, String.valueOf(areaPool),
//                    String.valueOf(amountFloor),differentService};
            String[] service = {id,nameService,String.valueOf(areaEmploy), String.valueOf(price),
                    String.valueOf(maximum), type,standard, differentService,
                    String.valueOf(areaPool),String.valueOf(amountFloor)};
            FileUtils.writeFile(service);
        } else if (fileName.equals(HOUSE)){
            do {
                System.out.println("Please input standard of room: ");
                standard=scanner.nextLine();
            }while (!Validator.isValidRegex(standard,Validator.SERVICE_NAME_REGEX));
            do {
                System.out.println("Please input amount of floor: ");
                amountFloor=Integer.parseInt(scanner.nextLine());
            }while (!Validator.isMoreThan(amountFloor,0));
            System.out.println("Please input different services:");
            String differentService=scanner.nextLine();
            FileUtils.writeFile(new String[] {id,nameService,String.valueOf(areaEmploy), String.valueOf(price),
                    String.valueOf(maximum), type,
                    standard,differentService, String.valueOf(amountFloor)});
        } else if (fileName.equals(ROOM)){
            do {
                System.out.println("Please input name of extra services: ");
                nameExtraService=scanner.nextLine();
            }while (!Validator.isValidExtraService(nameExtraService));

            System.out.println("Please input unit: ");
            String unit=scanner.nextLine();
            System.out.println("Please input price of extraservice: ");
            double priceExtra=Double.parseDouble(scanner.nextLine());
            FileUtils.writeFile(new String[] {id,nameService,String.valueOf(areaEmploy), String.valueOf(price),
                    String.valueOf(maximum), type,nameExtraService,unit, String.valueOf(priceExtra)});
        }
    }
//
    public static void main(String[] args) {
        MainController.displayMainMenu();
    }
}
