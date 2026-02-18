import java.util.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt(); // Number of test cases
            while (t-- > 0) {
                String s = sc.next();
                int n = s.length();
                
                // Extract the two halves
                String firstHalf = s.substring(0, n / 2);
                String secondHalf;
                
                if (n % 2 == 0) {
                    secondHalf = s.substring(n / 2);
                } else {
                    // Skip the middle character for odd length
                    secondHalf = s.substring(n / 2 + 1);
                }

                // Check if they are lapindromes
                if (isAnagram(firstHalf, secondHalf)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // Helper method to compare character frequencies
    private static boolean isAnagram(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        // Sorting is an easy way to compare frequencies
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
}
