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
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) { // 1 23 45 67 89 p = 3
    // Write your code here
        int front = p/2; //How many pages to turn from front
        int back; //How many pages to turn from back
        
        if (n % 2 == 1) { //If odd number of total pages it means back page uses both pages e.g 1 23 45
            back = (n-p) / 2; //Divide by 2 as there are 2 pages per flip (e.g so in total 1 flip)
        } else {  //If even, need to turn an additional page for back page e.g 1 23 45 6
            back = (n-p+1) / 2;
        }
        
        return Math.min(front, back);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}