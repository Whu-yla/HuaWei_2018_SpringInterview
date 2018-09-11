package cn.whu.HuaWei;

import java.util.Scanner;

public class Read_Bytes {

    public int[] result(String input, int numlength1,int numlength2){
        String temp1 = input.substring(0,numlength1);
        String temp2 = input.substring(numlength1,numlength1+numlength2);
        int[] result = new int[2];
        result[0] = Integer.valueOf(temp1,2);
        result[1] = Integer.valueOf(temp2,2);

        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(new Read_Bytes().result(input,4,5)[0]);
        System.out.println(new Read_Bytes().result(input,4,5)[1]);
    }
}
