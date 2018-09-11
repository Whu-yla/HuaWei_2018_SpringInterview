package cn.whu.HuaWei;

import java.util.Scanner;

public class BigMultiply{
    public static String bigNumberMulti(String num1, String num2) {
        char sign1 = num1.charAt(0);
        char sign2 = num2.charAt(0);

        String number1 = "";
        String number2 = "";

        if (sign1 == '-' || sign1 == '+') {
        number1 = num1.substring(1);
        } else {
        sign1 = '+';
        number1 = num1;
        }

        if (sign2 == '-' || sign2 == '+') {
        number2 = num2.substring(1);
        } else {
        sign2 = '+';
        number2 = num2;
        }

        int length1 = number1.length();
        int length2 = number2.length();

        boolean isDig1 = number1.matches("[1-9][0-9]*");
        boolean isDig2 = number2.matches("[1-9][0-9]*");
        if ((!isDig1&&length1!=1) || (!isDig2&&length2!=1)) {
        throw new NumberFormatException("输入的数据不是纯数字整数");
        }



        int maxLen = length1 + length2;
        int[] result = new int[maxLen];

        char[] char1 = new StringBuffer(number1).reverse().toString().toCharArray();
        char[] char2 = new StringBuffer(number2).reverse().toString().toCharArray();

        for (int i = 0; i < length1; i++) {
        for (int j = 0; j < length2; j++) {
        result[i + j] += (char1[i] - '0') * (char2[j] - '0');
        }
        }

        // 处理结果集合，如果是大于10的就向前一位进位，本身进行除10取余
        for (int i = 0; i < result.length; i++) {
        if (result[i] >= 10) {
        result[i + 1] += result[i] / 10;
        result[i] %= 10;
        }
        }

        // 处理结果,将最高位的0去掉,比如0090,去掉前面的两个无意义的0
        boolean flag = true;
        StringBuffer mutilResult = new StringBuffer();

        for (int i = maxLen - 1; i >= 0; i--) {
        if (result[i] == 0 && flag && i!=0) {
        continue;
        }
        flag = false;
        mutilResult.append(result[i]);
        }

        // 符号处理
        if (sign1 != sign2) {
        return "-" + mutilResult;
        } else {
        return mutilResult.toString();
        }
        }
        public static void main(String[] args){
            BigMultiply bm = new BigMultiply();
            System.out.println("-----输入两个大数------");
            Scanner scanner = new Scanner(System.in);
            String num1 = scanner.next();
            String num2 = scanner.next();
            String result = bm.bigNumberMulti(num1,num2);
            System.out.println("相乘结果为："+result);
            scanner.close();
        }
}