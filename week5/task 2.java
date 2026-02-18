import java.util.*;

public class Solution {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int currentSum = 0;

        // Constraint check: if the bar is shorter than the required segment length
        if (s.size() < m) {
            return 0;
        }

        // 1. Calculate the sum of the first 'm' squares (the first window)
        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }

        // Check if the first window meets the criteria
        if (currentSum == d) {
            count++;
        }

        // 2. Slide the window across the rest of the array
        for (int i = m; i < s.size(); i++) {
            // Subtract the element leaving the window and add the element entering
            currentSum = currentSum - s.get(i - m) + s.get(i);
            
            if (currentSum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(scanner.nextInt());
        }
        
        int d = scanner.nextInt();
        int m = scanner.nextInt();
        
        System.out.println(birthday(s, d, m));
        
        scanner.close();
    }
}
