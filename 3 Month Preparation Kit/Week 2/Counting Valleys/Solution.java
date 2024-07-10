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
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
        int valley = 0; //Number of valleys traversed
        int previousHeight = 0; //Previous height
        int height = 0; //Height we currently are at
        for (int i = 0; i < path.length(); i++) { //Loops through path
            previousHeight = height; //Sets previous height to height
            if(path.charAt(i) == 'U') { //If path is "U" then go up the valley
                height++; //Increment height
            } else if (path.charAt(i) == 'D') { //If path is "D" then go down the valley
                height--; //Decrement height
            }
            if (height == 0 && previousHeight == -1) { //If height is at sea level and previous height is 1 below sea level
                valley++;
            }
        }
        return valley;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}