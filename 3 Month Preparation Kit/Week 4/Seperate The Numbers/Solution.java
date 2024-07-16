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
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
        String beautiful = ""; //Keeps track of beautiful string
        String substring = ""; //Substring we are using
        BigInteger num = BigInteger.ZERO; //Initialise num
        for (int i = 1; i < s.length(); i++) { //Loop through whole whole string
            num = new BigInteger(s.substring(0,i)); //Checks with 1 digit, 2 digit etc...
            substring = s.substring(0, i); //Creates new substring with 1 digit, 2 digit etc...
            BigInteger newNum = num; //newNum so number can be incremented
            while(substring.length() < s.length()) { //While substring < string
                newNum = newNum.add(BigInteger.ONE); //Incrememnt number (newNum)
                substring += newNum; //Add newNum to substring
            }
            if (substring.equals(s)) { //If substring string equals original string it means it is beautiful string
                beautiful = "YES"; //Change beatiful to "YES"
                break; //String doesn't need to be checked anymore as it is beautiful
            }
        }
        
        if (beautiful.equals("YES")) { //Output
            System.out.println("YES " + num);
        } else {
            System.out.println("NO");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}