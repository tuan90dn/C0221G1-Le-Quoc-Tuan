package bai11_stack_queue.bai_tap.kiem_tra_dau_ngoac;

import java.util.Arrays;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Stack<String> bStack=new Stack<>();
        Boolean check=true;
        String left="";
        String string="s * ((s – a) * ((s – b)) * (s – c))";
        String array[]=string.split("");
        for (String sym:array){
            if (sym.equals("(")){
                bStack.push(sym);
            } else if (sym.equals(")")){
                if (bStack.size()==0){
                    check=false;
                } else {
                    left=bStack.pop();
                    if (left.equals(sym)){
                        check=false;
                    }
                }
            }
        }
        if (check&&bStack.size()==0){
            System.out.println("Đúng");
        } else {
            System.out.println("Sai");
        }
//        System.out.println(left);
//        System.out.println(bStack);
//        if (bStack.size()==0){
//            System.out.println("Biểu thức đúng");
//        } else {
//            System.out.println("Sai");
//        }
//        System.out.println(Arrays.toString(array));
//        for (int i=0;i<array.length;i++){
//            if (array[i].equals("(")){
//                bStack.push(array[i]);
//            } else if (array[i].equals(")")){
//                if (bStack.size()==0){
//                    check=false;
//                } else {
//                    String left =bStack.pop();
//                    if (left.length()!=)
//                }
//            }
//
//        }


    }
}
