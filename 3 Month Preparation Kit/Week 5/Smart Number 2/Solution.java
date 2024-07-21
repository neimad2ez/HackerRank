import java.io.*;
import java.util.*;

public class Solution {
    
    public static Boolean smartNumber(int num) {
        int val = (int) Math.sqrt(num); //If value is odd then it has multiple factors, if even then it only has 2 factors. 1 and itself. e.g 2 factors are 1 and 2. factors of 4 are 1, 2, 4
        if (val * val == num) { //val is whole number, no decimals so sqrt 2 = 1 rather than 1.414...
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) { //Loops through each input
            int number = scan.nextInt();
            Boolean smartNum = smartNumber(number); //Checks for smart number
            if (smartNum) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scan.close();   
    }
}
