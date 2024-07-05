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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        List<Integer> record = new ArrayList<>();
        int max = 0; //Number of maximum scores
        int min = 0; //Number of minimum scores
        int maxNum = scores.get(0); //Maximum number
        int minNum = scores.get(0); //Minimum number
        for (int i = 1; i < scores.size(); i++) { //Loops through whole list
            if (scores.get(i) > maxNum) { //If next element is greater than max num then
                max++; //Increment max count
                maxNum = scores.get(i); //Change new max
            }
            
            if (scores.get(i) < minNum) { //If next element less than min num then
                min++; //Increment min count
                minNum = scores.get(i); //Change new min
            }
        }
        record.add(max);
        record.add(min);
        return record;        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}