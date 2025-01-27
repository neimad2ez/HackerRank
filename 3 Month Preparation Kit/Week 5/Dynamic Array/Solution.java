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
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
        List<List<Integer>> arr = new ArrayList<>(); //Declare an empty 2d array
        List<Integer> answers = new ArrayList<>(); //results of type 2 query
        int lastAnswer = 0;
        
        for (int i = 0; i < n; i++) { //Creates n empty arrays in 2d array arr
            arr.add(new ArrayList<>());
        }
        
        for (int i = 0; i < queries.size(); i++) { //Loops through all queries
            int x = queries.get(i).get(1); //x
            int y = queries.get(i).get(2); //y
            if (queries.get(i).get(0).equals(1)) { //If query 1
               arr.get((x ^ lastAnswer) % n).add(y); //append y to arr[idx]
            } else if (queries.get(i).get(0).equals(2)) { //If query 2
                int idx = ((x ^ lastAnswer) % n); //idx = ((x ^ lastAnswer) % n)
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size()); //arr[idx][y % size(arr[idx])] = lastAnswer
                answers.add(lastAnswer); //Store new value of lastAnswer to answer array
            }
        }
        return answers;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}