class Solution {
    public void moveZeroes(int[] nums) {
        // Start a pointer to track the position of the next non-zero element
        int lastNonZeroIndex = 0;

        // First pass: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i];
                lastNonZeroIndex++;
            }
        }

        // Second pass: Fill the rest of the array with zeroes
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
