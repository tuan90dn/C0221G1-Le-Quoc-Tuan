package bai1_introduction_to_java.Bai_Tap;

import java.util.Scanner;
public class Doc_So_Thanh_Chu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber;
        System.out.println("Nhập cmm số vào đây");
        inputNumber = sc.nextInt();
        String tens = "";
        String hundred;
        String units = "";
        String result="";
        int hundredsDigit = inputNumber / 100;
        int tensDigits = (inputNumber - hundredsDigit * 100) / 10;
        int unitDigits = (inputNumber - hundredsDigit * 100 - tensDigits * 10);
        if (inputNumber==0){
            System.out.println("zero");
        }
        switch (hundredsDigit) {
            case 1:
                hundred = "one hundred ";
                break;
            case 2:
                hundred = "two hundred ";
                break;
            case 3:
                hundred = "three hundred";
                break;
            case 4:
                hundred = "four hundred";
                break;
            case 5:
                hundred = "five hundred ";
                break;
            case 6:
                hundred = "six hundred ";
                break;
            case 7:
                hundred = "seven hundred ";
                break;
            case 8:
                hundred = "eight hundred ";
                break;
            case 9:
                hundred = "nine hundred ";
                break;
            default:
                hundred = " ";
        }
        if (tensDigits > 1) {
            switch (tensDigits) {
                case 2:
                    tens = "twenty";
                    break;
                case 3:
                    tens = "thirty";
                    break;
                case 4:
                    tens = "forty";
                    break;
                case 5:
                    tens = "fifty";
                    break;
                case 6:
                    tens = "sixty";
                    break;
                case 7:
                    tens = "seventy";
                    break;
                case 8:
                    tens = "eighty";
                    break;
                case 9:
                    tens = "ninety";
                    break;
                default:
                    tens = "";
            }
            switch(unitDigits){
                case 1:
                    units = "one";
                    break;
                case 2:
                    units = "two";
                    break;
                case 3:
                    units = "three";
                    break;
                case 4:
                    units = "four";
                    break;
                case 5:
                    units = "five";
                    break;
                case 6:
                    units = "six";
                    break;
                case 7:
                    units = "seven";
                    break;
                case 8:
                    units = "eight";
                    break;
                case 9:
                    units = "nine";
                    break;
                default:
                    units = "";
            }
            result=hundred+"and"+" "+tens+" "+units;

        }
        else if( tensDigits>0)
        {
            switch (unitDigits){
                case 0:
                    tens="ten";
                    break;
                case 1:
                    tens="eleven";
                    break;
                case 2:
                    tens="twelve";
                    break;
                case 3:
                    tens="thirteen";
                    break;
                case 4:
                    tens="fourteen";
                    break;
                case 5:
                    tens="fifteen";
                    break;
                case 6:
                    tens="sixteen";
                    break;
                case 7:
                    tens="seventeen";
                    break;
                case 8:
                    tens="eighteen";
                    break;
                case 9:
                    tens="nineteen";
                    break;
                default:
                    tens="";
            }
            result=hundred+" "+ "and"+" "+tens;
        }else {

            switch(unitDigits){


                case 0:
                    units=" ";
                    break;
                case 1:
                    units = " and one";
                    break;
                case 2:
                    units = " and two";
                    break;
                case 3:
                    units = "and three";
                    break;
                case 4:
                    units = "and four";
                    break;
                case 5:
                    units = "and five";
                    break;
                case 6:
                    units = "and six";
                    break;
                case 7:
                    units = "and seven";
                    break;
                case 8:
                    units = "and eight";
                    break;
                case 9:
                    units = "and nine";
                    break;
                default:
                  units="";

            }
            result=hundred+units;

        }
        System.out.println(result);
    }
}
