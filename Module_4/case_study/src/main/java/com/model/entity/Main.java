package com.model.entity;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        for (int i = 0; i<7; i++) {
//            for (int j = 0; j<15; j++) {
//                if (i==0| i==3 | i==6) {
//                    System.out.print(" * ");
//                } else {
//                    if (j==0 | j==7 | j==14) {
//                        System.out.print(" * ");
//                    } else {
//                        System.out.print(" ");
//                        System.out.print(" ");
//                        System.out.print(" ");
//                    }
//                }
//            }
//            System.out.println();
////        }
//        int arr[]={8,-1,-2,-3,-4,-5};
//        System.out.println(findSecond(arr));
        String strings="aabbcdcc";
        System.out.println(findWord(strings));
    }
//    public static int findSecondMaxNumber(int[] arr){
//        int num=0;
//        int max=arr[0];
//        for (int i=1;i<arr.length;i++){
//            if (arr[i]>max){
//                num=max;
//                max=arr[i];
//            }else if (arr[i]>num){
//                    num=arr[i];
//            } else if(){
//                num=arr[i];
//            }
//        }
//        return num;
//    }
    public static int findSecond(int [] arr){
        int a;
        Arrays.sort(arr);
        for (int i = arr.length-1; i >0; i--) {
            if(arr[i]!=arr[i-1]){
                return arr[i-1];
            }
        }
        return 0;
    }
    public static char[] findWord(String strings){
        char[] array = strings.toCharArray();
        StringBuilder newArray = new StringBuilder();
        Arrays.sort(array);
        for (int i =0;i<array.length-1;i++){
            if (array[i+1]==array[i]){
                newArray.append(array[i+1]);
            }
        }

        String chars = newArray.toString();
        return chars.toCharArray();
    }

}
