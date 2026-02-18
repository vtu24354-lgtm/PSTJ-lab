import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int leftToRightSum = 0;
        int rightToLeftSum = 0;

        for (int i = 0; i < n; i++) {
            // Primary diagonal: arr[0][0], arr[1][1], arr[2][2]...
            leftToRightSum += arr.get(i).get(i);
            
            // Secondary diagonal: arr[0][n-1], arr[1][n-2], arr[2][n-3]...
            rightToLeftSum += arr.get(i).get(n - 1 - i);
        }

        // Return the absolute difference
        return Math.abs(leftToRightSum - rightToLeftSum);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<List<Integer>> row = new ArrayList<>(); // Note: This structure follows HackerRank style
            List<Integer> rowItems = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowItems.add(scanner.nextInt());
            }
            arr.add(rowItems);
        }

        int result = Result.diagonalDifference(arr);
        System.out.println(result);
        
        scanner.close();
    }
}
