package cn.whu.HuaWei;

public class Longest_String {
    private static String input = "abcd12345ed125ss123058789gjkg1293723190jji";

    public int[] result(String a){
        char[] chars = a.toCharArray();
        String temp_str = "";
        String out_str = "";
        int[] result = new int[2];
        int max_length = 0 ;

        for(int i = 0 ; i < a.length()-1 ;i++) {
            if ((chars[i] >= '0') && chars[i] <= '9') {
                temp_str += chars[i];
                while(chars[i+1] >= '0' && chars[i+1]<='9'&& i < a.length()-2){
                    temp_str += chars[i+1];
                    i++;
                }
                if(chars[a.length()-1] >= '0' && chars[a.length()-1]<='9' && i == a.length()-2 && chars[a.length()-2] >= '0' && chars[a.length()-2]<='9'){
                    temp_str += chars[a.length()-1];
                }
                if (temp_str.length() > max_length) {
                    max_length = temp_str.length();
                    out_str = temp_str;
                }
                temp_str = "";
            }
        }
        result[0]=Integer.parseInt(out_str);
        result[1]=out_str.length();
        return result;
    }

    public static void main(String[] args){
    System.out.println(new Longest_String().result(input)[0]);
    System.out.println(new Longest_String().result(input)[1]);
    }
}
