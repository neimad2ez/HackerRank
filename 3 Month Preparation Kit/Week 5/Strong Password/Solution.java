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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        int digit = 0;
        int lowercase = 0;
        int uppercase = 0;
        int special = 0;
        
        int charToAdd = 0; //Number of checks incomplete e.g doesn't include a number therefore number = 0
        
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        
        for (int i = 0; i < password.length(); i++) { //Loops through password
            String s = password.charAt(i) + ""; // + "" because String s can not equal a char.
            if (numbers.contains(s)) { //Checks if all of numbers contains the char
                digit++;
            }
            if (lower_case.contains(s)) { //Checks if any lower case contains the char
                lowercase++;
            }
            if (upper_case.contains(s)) { //Checks if any upper case contains the char
                uppercase++;
            }
            if (special_characters.contains(s)) { //Checks if any special characters contain the char
                special++;
            }
        }
        
        if (digit == 0) { //Checks if there is a number in the string
            charToAdd++;
        }
        if (lowercase == 0) { //Checks if lowercase character in the string
            charToAdd++;
        }
        if (uppercase == 0) { //Checks if uppercase character in the string
            charToAdd++;
        }
        if (special == 0) { //Checks if special character in string
            charToAdd++;
        }
        
        if ((6-n) > charToAdd) { //Checks if num of characters away from necessary length (6-n) > charToAdd because if it is then the minimum number of characters must be 6-n as that is necessary for password to even work.
            return 6-n;
        }
        
        return charToAdd;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}