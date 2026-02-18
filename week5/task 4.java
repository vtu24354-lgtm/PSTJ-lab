class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currentMax = 0;
        int minSum = nums[0], currentMin = 0;

        for (int x : nums) {
            // Standard Kadane's to find Maximum Subarray
            currentMax = Math.max(x, currentMax + x);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's variation to find Minimum Subarray
            currentMin = Math.min(x, currentMin + x);
            minSum = Math.min(minSum, currentMin);

            totalSum += x;
        }

        // If all numbers are negative, maxSum will be the largest element.
        // totalSum == minSum means we selected the entire array as the "minimum".
        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        } else {
            return maxSum;
        }
    }
}
