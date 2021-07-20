package bai11_stack_queue.bai_tap.dao_nguoc_stack;

import java.util.Arrays;
import java.util.Stack;

public class Stack_int {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arrayNumbers = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arrayNumbers));
        for (int number : arrayNumbers) {
            stack.push(number);
        }
        System.out.println(stack);//
        for (int i = 0; i<arrayNumbers.length; i++){
           arrayNumbers[i]=stack.pop();
        }
        System.out.println(Arrays.toString(arrayNumbers));
//
    }


}
