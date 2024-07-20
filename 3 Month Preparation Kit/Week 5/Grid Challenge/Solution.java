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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
    // Write your code here
        for (int i = 0; i < grid.size(); i++) { //Loops through all elements in grid
            char[] c = grid.get(i).toCharArray(); //Turns string e.g ebacd to char array
            Arrays.sort(c); //Sorts char array (possible to rearrange grid alphabetically)
            String sorted = new String(c); //Creates the new string of sorted chars
            grid.set(i, sorted); //Sets sorted char as char
        }
    
        for (int i = 0; i < grid.get(0).length(); i++) { //Loops through every letter in a word e.g ebacd
            for (int j = 0; j < grid.size()-1; j++) { //Loops through every word e.g ebacd fghij etc.
                if (grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)) { //Checks if adjacent elements are in alphabetical order
                    return "NO";
                }
            }
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

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