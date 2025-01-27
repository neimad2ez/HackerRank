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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
        s = s.toLowerCase();
        Set<Character> alphabet = new HashSet<>(); //HashSet so it can search if it contains certain letter
        for (int i = 0; i < s.length(); i++) { //Loop through string
            if (Character.isLetter(s.charAt(i))) { //Prevents empty space entering HashSet
                if (!(alphabet.contains(s.charAt(i)))) { //If letter is not already in alphabet hashset
                    alphabet.add(s.charAt(i)); //Add letter to alphabet hashset
                }
            }
        }
        
        if (alphabet.size() == 26) { //Checks if alphabet size is 26
            return "pangram";
        }
        return "not pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
