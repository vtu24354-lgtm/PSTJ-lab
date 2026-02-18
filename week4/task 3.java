import java.util.*;

public class Solution {

    /**
     * Function to compare the triplets and calculate scores.
     */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(aliceScore);
        result.add(bobScore);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading Alice's triplet
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            a.add(scanner.nextInt());
        }

        // Reading Bob's triplet
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            b.add(scanner.nextInt());
        }

        // Calculate result
        List<Integer> result = compareTriplets(a, b);

        // Printing the output in the required format
        System.out.println(result.get(0) + " " + result.get(1));

        scanner.close();
    }
}
