package bai12_java_collection_framework.bai_tap.dem_so_lan_xuat_hien_cua_tu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class DemTu {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
//        Set<String> keys = treeMap.keySet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần đếm từ: ");
        String string = scanner.nextLine().toLowerCase();
        String[] array = string.split(" ");
        System.out.println(Arrays.toString(array));
//        treeMap.put("quoc", 1);
//        treeMap.put("tuan", 1);
        System.out.println(treeMap);
        for (String temp : array) {
            if (treeMap.containsKey(temp)) {
                treeMap.put(temp, treeMap.get(temp) + 1);
            } else {
                treeMap.put(temp, 1);
            }
        }
        System.out.println(treeMap);
    }
}
