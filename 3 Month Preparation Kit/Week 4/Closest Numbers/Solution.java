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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        List<Integer> closest = new ArrayList<>();
        int difference = Integer.MAX_VALUE;
        Collections.sort(arr); //Sort array
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i + 1)) < difference) { //If absolute value of pair < diff then clear current smallest abs diff array, replace difference value and add new values to closest array
                closest.clear();
                difference = Math.abs(arr.get(i) - arr.get(i + 1));
                closest.add(arr.get(i));
                closest.add(arr.get(i + 1));
            } else if (Math.abs(arr.get(i) - arr.get(i + 1)) == difference) { //If absolute value has same difference as other absolute value then add to closest array
                closest.add(arr.get(i));
                closest.add(arr.get(i + 1));
            }
        }
        return closest;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

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