class Solution {
    public int[][] transpose(int[][] matrix) {
        // Get the original dimensions
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Create a new matrix with swapped dimensions
        int[][] result = new int[cols][rows];
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // The element at [r][c] moves to [c][r]
                result[c][r] = matrix[r][c];
            }
        }
        
        return result;
    }
}
