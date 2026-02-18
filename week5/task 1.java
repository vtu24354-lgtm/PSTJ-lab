class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element of the array
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide: Start fresh at nums[i] or extend the previous subarray?
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update the overall maximum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
