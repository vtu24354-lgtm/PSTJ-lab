import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        matrixRotation(matrix, m, n, r);
    }

    static void matrixRotation(int[][] matrix, int m, int n, int r) {
        int numRings = Math.min(m, n) / 2;
        
        for (int i = 0; i < numRings; i++) {
            // Extract the ring into a list
            List<Integer> ring = new ArrayList<>();
            
            // Top row
            for (int j = i; j < n - i; j++) ring.add(matrix[i][j]);
            // Right column (minus corners)
            for (int j = i + 1; j < m - i - 1; j++) ring.add(matrix[j][n - i - 1]);
            // Bottom row (reverse)
            for (int j = n - i - 1; j >= i; j--) ring.add(matrix[m - i - 1][j]);
            // Left column (reverse, minus corners)
            for (int j = m - i - 2; j > i; j--) ring.add(matrix[j][i]);
            
            // Calculate effective rotation
            int p = ring.size();
            int actualRotation = r % p;
            
            // Rotate the list (anti-clockwise)
            // Elements at index 'actualRotation' move to index 0
            Collections.rotate(ring, -actualRotation);
            
            // Put the rotated elements back into the matrix
            int count = 0;
            for (int j = i; j < n - i; j++) matrix[i][j] = ring.get(count++);
            for (int j = i + 1; j < m - i - 1; j++) matrix[j][n - i - 1] = ring.get(count++);
            for (int j = n - i - 1; j >= i; j--) matrix[m - i - 1][j] = ring.get(count++);
            for (int j = m - i - 2; j > i; j--) matrix[j][i] = ring.get(count++);
        }
        
        // Print the result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
