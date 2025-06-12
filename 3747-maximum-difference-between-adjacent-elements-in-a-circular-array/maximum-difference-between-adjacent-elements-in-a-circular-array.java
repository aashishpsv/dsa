class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDifference = 0;

        // Traverse through the array to find maximum adjacent difference
        for (int i = 0; i < n; i++) {
            int currentDiff = Math.abs(nums[i] - nums[(i + 1) % n]); // Circular adjacency
            maxDifference = Math.max(maxDifference, currentDiff);
        }

        return maxDifference;
    }
}
