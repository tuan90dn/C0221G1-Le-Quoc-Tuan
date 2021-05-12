package thi_module2.controller;



import furuma_resort.commons.FileUtils;
import furuma_resort.commons.StringUtils;
import thi_module2.commons.ChuyenChuoi;
import thi_module2.commons.FileUtil;
import thi_module2.commons.StringUtil;
import thi_module2.commons.Validators;
import thi_module2.exceptions.*;
import thi_module2.model.DanhBa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_Controller {
    private static Scanner scanner=new Scanner(System.in);
    private static String DANHBA = "danhba";

    public static void main(String[] args) {
        Main_Controller.hienthiMenu();
    }
    public static void hienthiMenu(){
        int choose=-1;
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1.\tXem danh sách\n" +
                    "2.\tThêm mới\n" +
                    "3.\tCập nhật\n" +
                    "4.\tXóa\n" +
                    "5.\tTìm kiếm\n" +
                    "6.\tĐọc từ file\n" +
                    "7.\tGhi vào file\n"+
                    "8.\tThoát");
            System.out.println("Chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    hienthiDanhBa(DANHBA);
                    break;
                case 2:
                    themDanhBa(DANHBA);
                    break;
                case 3:
                    capnhatDanhBa();
                    break;
                case 4:
                    xoaDanhBa(DANHBA);
                    break;
                case 5:
                    timkiemFile();
                    break;
                case 6:
                    docFile();
                    break;
                case 7:
                    ghiFile();
                    break;
            }

        }while (choose != 8);

    }

    private static void ghiFile() {
//        Class FileUtil.
    }

    private static void docFile() {
//        Class FileUtil.
    }

    private static void timkiemFile() {
    }


    private static void xoaDanhBa(String fileName) {
        hienthiDanhBa(fileName);
        System.out.println("Hãy nhập số thứ tự bạn muốn xóa: ");
        int choose=Integer.parseInt(scanner.nextLine());
        List<DanhBa> listDanhBa= readDanhBa(fileName);
        listDanhBa.remove(choose-1);
        DanhBa mangDanhBa;
        FileUtil.deleteFile();
        for (int i=0;i<listDanhBa.size();i++){
            mangDanhBa=listDanhBa.get(i);
            FileUtil.writeFile(mangDanhBa.toString().split(StringUtils.COMMA));
        }
    }

    private static void capnhatDanhBa() {
//

    }

    private static void themDanhBa(String fileName) {
        boolean flag;
        String soDienThoai;
        do {
            flag=true;
            System.out.println("Hãy nhập số điện thoại: ");
            soDienThoai=scanner.nextLine();
            try {
                Validators.isSoDienThoai(soDienThoai);
            } catch (SoDienThoaiException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);
        String nhomDanhBa=null;
        do {
            flag=true;
            System.out.println("Hãy nhập nhóm của danh bạ: ");
            nhomDanhBa=scanner.nextLine();
            try {
                Validators.isValidFullName(nhomDanhBa);
            } catch (TenException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);


            System.out.println("Hãy nhập họ và tên của danh bạ: ");
            String hoten=scanner.nextLine();



        String gioitinh=null;
        do {
            flag=true;
            System.out.println("Hãy nhập giới tính: ");
            gioitinh= ChuyenChuoi.chuyenChuoi(scanner.nextLine());
            try {
                Validators.isValidGender(gioitinh);
            } catch (GioiTinhException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);

            System.out.println("Hãy nhập địa chỉ: ");
            String diachi=scanner.nextLine();


        String ngaysinh=null;
        do {
            flag=true;
            System.out.println("Please input birthday: ");
            ngaysinh=scanner.nextLine();
            try {
                Validators.isValidBirthday(ngaysinh);
            } catch (BirthdaysException e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);
        String email=null;
        do {
            flag=true;
            System.out.println("Hãy nhập email: ");
            email=scanner.nextLine();
            try {
                Validators.isValidEmail(email);
            } catch (EmailExceptions e) {
                flag=false;
                e.printStackTrace();
            }
        } while (!flag);
        FileUtil.setPath(fileName);
        FileUtil.writeFile(new String[]{soDienThoai,nhomDanhBa,hoten,gioitinh,diachi,ngaysinh,email});
        System.out.println("Đã thêm mới danh bạ!");

    }

    private static void hienthiDanhBa(String fileName) {
        System.out.println("Danh sách danh bạ: ");
        int i;
        List<DanhBa> listReadService= readDanhBa(fileName);
        DanhBa danhBa=null;
        for (i=0;i<listReadService.size();i++){
            danhBa=listReadService.get(i);
            System.out.print((i+1)+".");
            danhBa.showInfor();
        }
    }
    public static List<DanhBa> readDanhBa(String fileName) {
        FileUtil.setPath(fileName);
        List<String> resultReadFile = FileUtil.readFile();
        List<DanhBa> listDanhBa = new ArrayList<>();
        DanhBa danhBa = null;
        String[] propertyArray = null;
        for (String property : resultReadFile) {
            propertyArray = property.split(StringUtil.COMMA);

            danhBa = new DanhBa();

            danhBa.setSoDienThoai(propertyArray[0]);
            danhBa.setNhomDanhBa(propertyArray[1]);
            danhBa.setHoten(propertyArray[2]);
            danhBa.setGioitinh(propertyArray[3]);
            danhBa.setDiachi(propertyArray[4]);
            danhBa.setNgaySinh(propertyArray[5]);
            danhBa.setEmail(propertyArray[6]);
            listDanhBa.add(danhBa);
        }
        return listDanhBa;
    }
}
