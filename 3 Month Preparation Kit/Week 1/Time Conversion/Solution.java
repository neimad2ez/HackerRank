import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

     public static String timeConversion(String s) {
        // Write your code here
            String[] str = s.split(":"); //Split into parts
            if (s.endsWith("PM")) { //Handles PM
                if (!(str[0].equals("12"))) { //If str[0] == 12 then it will still be 12 in 24 hour clock
                    int num = Integer.valueOf(str[0]) + 12; //Add 12 as it is PM
                    str[0] = String.valueOf(num); //Change str[0] to new num
                }
            }
            
            if (s.endsWith("AM")) { //Handles AM
                if (s.substring(0, 2).equals("12")) { //If 12AM then it is 00 in 24 hour clock
                    str[0] = "00";
                }
            }
            str[2] = str[2].substring(0, str[2].length()-2); //Removes PM or AM
            return str[0] + ":" + str[1] + ":" + str[2];
        }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
