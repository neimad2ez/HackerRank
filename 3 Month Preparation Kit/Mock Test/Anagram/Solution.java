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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
    // Write your code here
        ArrayList<Character> s1 = new ArrayList<>(); //Char array for first half of the string
        ArrayList<Character> s2 = new ArrayList<>(); //Char array for second half of the string
        if ((s.length()) % 2 == 0) { //Only even length strings can be anagrams
            String first = s.substring(0, s.length() / 2); //First half of string
            String second = s.substring(s.length() / 2, s.length()); //Second half of string
            for (char c: first.toCharArray()) { //Turns first string into char
                s1.add(c); //Adds to char array s1
            }
            
            for (char c: second.toCharArray()) { //Turns second string into char
                s2.add(c); //Adds to char array s2
            }
            
            for (int i = 0; i < first.length(); i++) { //Loops through first string e.g aaa
                if (s1.contains(s2.get(i))) { //If s1 has an element in s2 then
                    s1.remove(s2.get(i)); //Removes element from s1, remainder of s1 is number of elements that need to be changed in order for it to be an anagram
                }
            }
            return s1.size();
        }
        return -1;
    }


}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}