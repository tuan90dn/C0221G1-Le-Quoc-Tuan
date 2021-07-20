package bai11_stack_queue.bai_tap.dao_nguoc_stack;

import java.util.Arrays;
import java.util.Stack;

public class WStack {
    public static void main(String[] args) {
        Stack<String> wStack=new Stack<>();
        String string="mWord";
        String array[]=string.split("");
        System.out.println(Arrays.toString(array));
        for (String c:array){
            wStack.push(c);
        }
        for (int i=0;i<array.length;i++){
            array[i]=wStack.pop();
            System.out.print(array[i]);
        }

    }

}
