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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
    // Write your code here
        Collections.sort(sticks); //Sorts array
        List<Integer> arr = new ArrayList<>();
        int index = 0, max = 0, sum = 0;
        for (int i = 0; i < sticks.size() - 2; i++) { //Loops through all elements
            if (!(degenerate(sticks.get(i), sticks.get(i + 1), sticks.get(i + 2)))) { //Checks if degenerate triangle
                for (int j = 0; j < 3; j++) {
                    sum += sticks.get(i + j); //Sums sticks.get(i) + sticks.get(i+1) + sticks.get(i+2);
                }
                if (sum > max) { //Finds longest perimeter
                    index = i; //Stores index
                    max = sticks.get(i) + sticks.get(i + 1) + sticks.get(i + 2); //Sets new max
                }
            }
        }   
        
        if (max == 0) { //If max hasn't changed then degenerate triangles
            arr.add(-1); //No non degenerate triangle exists return -1
        } else {
            for (int i = 0; i < 3; i++) { //Add max elements to array
                arr.add(sticks.get(index + i)); //Adds all 3 elements from max array
            }   
        }
        return arr;
    }
    
    public static boolean degenerate(int a, int b, int c) {
        if (a + b <= c) return true; //Checks if 2 lengths bigger than 1 length, if smaller then its degenerate
        if (a + c <= b) return true;
        if (b + c <= a) return true;
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

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