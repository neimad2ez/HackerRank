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
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
    // Write your code here
        for (int i = 0; i < A.size(); i++) { //Sort array A' in ascending order
            for (int j = i + 1; j < A.size(); j++) { //Checks elements after i
                if (A.get(j) < A.get(i)) { //Finds smallest element first
                    int temp = A.get(i);
                    A.set(i, A.get(j));
                    A.set(j, temp);
                }
            }
        }
        
        for (int i = 0; i < B.size(); i++) { //Sort array B' in descending order
            for (int j = i + 1; j < B.size(); j++) { //Checks elements after i
                if (B.get(j) > B.get(i)) { //Finds biggest element first
                    int temp = B.get(i);
                    B.set(i, B.get(j));
                    B.set(j, temp);
                }
            }
        }
        
        for (int i = 0; i < A.size(); i++) { //Checks if A[i] and B[i] >= k
            if (A.get(i) + B.get(i) < k) { // If false returns "NO"
                    return "NO";
            }
        }
        
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.twoArrays(k, A, B);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}