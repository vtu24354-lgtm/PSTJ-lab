import java.io.*;
import java.util.*;

public class Solution {

    // Function to calculate minimum deletions
    public static int alternatingCharacters(String s) {
        int deletions = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            // If the current character is the same as the next, 
            // we must delete one of them.
            if (s.charAt(i) == s.charAt(i + 1)) {
                deletions++;
            }
        }
        
        return deletions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of queries
        if (sc.hasNextInt()) {
            int q = sc.nextInt();
            // Consume the newline character
            sc.nextLine(); 
            
            while (q-- > 0) {
                String s = sc.nextLine();
                System.out.println(alternatingCharacters(s));
            }
        }
        sc.close();
    }
}
