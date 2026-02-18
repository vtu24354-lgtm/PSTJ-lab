import java.util.Scanner;

public class Solution {

    /**
     * Calculates the maximum subarray sum and maximum subsequence sum.
     * @param arr The input array of integers
     * @return An array where result[0] is max subarray and result[1] is max subsequence
     */
    public static int[] maxSubarray(int[] arr) {
        // Initialize values with the first element to handle arrays 
        // that contain only negative numbers.
        int maxSubarrayEndingHere = arr[0];
        int maxSubarraySoFar = arr[0];
        
        int maxSubsequenceSum = 0;
        int maxElement = arr[0];
        boolean hasPositive = false;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            // --- Subarray Logic (Kadane's Algorithm) ---
            if (i > 0) {
                // Should we start a new subarray or extend the existing one?
                maxSubarrayEndingHere = Math.max(current, maxSubarrayEndingHere + current);
                // Update the global maximum subarray found so far
                maxSubarraySoFar = Math.max(maxSubarraySoFar, maxSubarrayEndingHere);
            }

            // --- Subsequence Logic ---
            if (current > 0) {
                maxSubsequenceSum += current;
                hasPositive = true;
            }
            // Keep track of the "least negative" element in case all are negative
            if (current > maxElement) {
                maxElement = current;
            }
        }

        // If no positive numbers were found, the best subsequence is the largest single element
        int finalSubsequence = hasPositive ? maxSubsequenceSum : maxElement;

        return new int[]{maxSubarraySoFar, finalSubsequence};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                int[] result = maxSubarray(arr);
                System.out.println(result[0] + " " + result[1]);
            }
        }
        scanner.close();
    }
}
