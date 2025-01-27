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
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
    // Write your code here
        int lettersChanged = 0; //Number of letters changed
        for (int i = 0; i < s.length(); i++) { //Loops through whole string
            if (i % 3 == 0 || i % 3 == 2) { //Modulo, if index mod 3 == 0 or 2 it means letter is "S"
                if (s.charAt(i) != 'S') {
                    lettersChanged++; 
                }
            } else if (i % 3 == 1) { //Modulo, if i mod 3 == 1 it means letter is "O"
                if (s.charAt(i) != 'O') {
                    lettersChanged++;
                }
            }
        }
        return lettersChanged;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}