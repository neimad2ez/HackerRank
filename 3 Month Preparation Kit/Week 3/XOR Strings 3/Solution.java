import java.util.Scanner;

public class Solution {

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) //If both strings have 1 or 0 then XOR incorrect.
                res += "0";
            else //If strings different e.g 0 and 1 or 1 and 0 then XOR correct.
                res += "1";
        }

        return res;
    }

    public static void main(String[] args) {

        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));
        in.close();
    }

}