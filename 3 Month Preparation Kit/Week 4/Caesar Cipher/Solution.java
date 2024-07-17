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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        String t = "";
        for (int i = 0; i < s.length(); i++) { //Loops through string
            int ascii = s.charAt(i); //Goes each character one by one
            k = k % 26; //Regardless of how big k is, in the end it cycles alphabet x times and goes up by times e.g k = 87 then alphabet repeats 3 times and has mod 9, so rotate alphabet by 9
            if (ascii >= 65 && ascii <= 90) { //Capital letters
                char c = (char) (ascii + k); //Makes new character with k
                if (c > 90) { //If greater than Capital letters then it needs to start back at 'A'
                    c = (char) ((c % 90) + 64);
                }
                t = t + c;
            } else if (ascii >= 97 && ascii <= 122) { //Lowercase letters
                char c = (char) (ascii + k); //Makes new character with k
                if (c > 122) { //If greater than Lowercase letters then it needs to start back at 'a'
                    c = (char) ((c % 122) + 96);
                }
                t = t + c;
            } else { //If a character that isn't a letter add original character
                t = t + (char) ascii;
            }
        }
        return t;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}