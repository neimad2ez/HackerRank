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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int factorElement = 0; //Number of factor elements
        List<Integer> elements = new ArrayList<>(); //Elements that may be factor element
        
        for (int i = a.get(a.size() - 1); i <= b.get(0); i++) { //Loops from last element in a to first element in b e.g 6-24
            int count = 0; //Keeps track of number of times element is divisible by elements of a
            for (int j = 0; j < a.size(); j++) { //Loops through all elements in array a
                if (i % a.get(j) == 0) { //If the number is divisible by the element in array
                    count++; //Incremement count
                }
            }
            
            if (count == a.size()) { //If count == a.size() (number is divisible by all elements in a) then
                elements.add(i); //Add to elements array
            }
        }
        
        for (int i = 0; i < elements.size(); i++) { //Loop through all elements
            int count = 0; //Keeps track of number of times element is divisible by elements of b
            for (int j = 0; j < b.size(); j++) { //Loop through all elements in array b
                if (b.get(j) % elements.get(i) == 0) { //If element in b is divisible by element then
                    count++; //Increment count
                }
            }
            
            if (count == b.size()) { //If count ==b.size() (all elements in b divisible by number) then
                factorElement++; //Increment number of factor elements
            }
        }
        return factorElement;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}