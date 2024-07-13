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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < 6; i++) { //Create array of ids of birds and number of times they are spotted
            id.add(0);
        }
        
        for (int i = 0; i < arr.size(); i++) {  //Loops through all ids and incrememnts id ArrayList
            id.set(arr.get(i), id.get(arr.get(i)) + 1);
        }
        
        int max = 0;
        int maxFreq = 0;
        for (int i = 0; i < id.size(); i++) { //Loops through all ids
            if (id.get(i) > maxFreq) { //Checks for id of bird spotted the most
                maxFreq = id.get(i); //Changes max freq
                max = i; //Changes id of bird spotted the most
            }
        }
        
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
