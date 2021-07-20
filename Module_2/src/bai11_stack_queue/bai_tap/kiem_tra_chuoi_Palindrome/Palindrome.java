package bai11_stack_queue.bai_tap.kiem_tra_chuoi_Palindrome;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String string = "Able was I ere I saw Elba";
        String array[] = string.split("\\s");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
//        System.out.println(Arrays.toString(array));
        for (String temp : array) {
            stack.push(temp);
            queue.add(temp);
        }
        Boolean check=false;
        for (int i=0;i<stack.size();i++){
            for (int j=0;j<queue.size();j++){
                if (queue.remove()==stack.pop()){
                    check=true;
                }
            }
        }
        if (check){
            System.out.println("Đây là chuỗi Palindrome");
        } else {
            System.out.println("Không phải chuỗi Palindrome");
        }
    }

}
