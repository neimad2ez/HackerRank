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
     * Complete the 'fibonacciModified' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t1
     *  2. INTEGER t2
     *  3. INTEGER n
     */

    public static String fibonacciModified(int t1, int t2, int n) {
    // Write your code here
        BigInteger tn = BigInteger.valueOf(0); //BigInteger used as int not big enough to hold output.
        BigInteger b1 = BigInteger.valueOf(t1); //Replace all values t1, t2 and tn is result
        BigInteger b2 = BigInteger.valueOf(t2);
        for (int i = 0; i < n-2; i++) { //Loops through n elements (-2 because t1 and t2 already exist)
            tn = b1.add((b2.multiply(b2))); //b1 + b2 squared.
            b1 = b2; //Change t1 to t2
            b2 = tn; //Change t2 to result
        }
        return String.valueOf(tn); //Return value
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int t1 = Integer.parseInt(firstMultipleInput[0]);

        int t2 = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        String result = Result.fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
