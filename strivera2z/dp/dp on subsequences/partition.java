We are given an array ‘ARR’ with N positive integers. We need to find if we can partition the array into two subsets such that the sum of elements of each subset is equal to the other.

If we can partition, return true else return false.
ex:[2,4,5,5,6,2] = [2,4,6] and [5,5,2]

let total sum be s. so we need it to divide array into 2 parts with sum/2. so ie target = s/2. so same as dp-14.

recusrsion:
class Solution {
    boolean f(int arr[],int target,int i){
        if(target==0) return true;
        if(i==0)return (arr[i]==target);
        boolean np= f(arr,target,i-1);
        boolean p = false;
        if(arr[i] <= target) p = f(arr,target-arr[i],i-1);
        return p || np;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(sum%2!=0)return false;
        return f(nums,sum/2,nums.length-1);
    }
}

memo:
class Solution {
    boolean f(int arr[],int target,int dp[][],int i ){
        if(target==0) return true;
        if(i==0)return (arr[i]==target);
        if(dp[i][target]!=-1){
            return dp[i][target] == 0 ? false : true;
        }
        boolean np= f(arr,target,dp,i-1);
        boolean p = false;
        if(arr[i] <= target) p = f(arr,target-arr[i],dp,i-1);
        dp[i][target] = np || p ? 1 : 0;
        return p || np;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(sum%2!=0)return false;
        int dp[][] = new int[nums.length][(sum/2)+1];
        for(int row[] : dp) Arrays.fill(row,-1);
        return f(nums,sum/2,dp,nums.length-1);
    }
}

tabulu:
class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;int sum = 0;for(int i: arr) sum+=i ;  if(sum%2!=0)return false;
        boolean dp[][] = new boolean[arr.length][(sum/2)+1];
        int k = sum/2;
       for (int i = 0; i < n; i++)  dp[i][0] = true;
        if (arr[0] <= k) { dp[0][arr[0]] = true; } // Initialize the first column of the DP table
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }}
        return dp[n - 1][k];// The final result is stored in the bottom-right cell of the DP table
    }
}

space opti:
class Solution {
   
    public boolean canPartition(int[] arr) {
        int n=arr.length;   int sum = 0;   for(int i: arr) sum+=i;
        if(sum%2!=0)return false;
        int k = sum/2; boolean prev[] = new boolean[k + 1];
            prev[0] = true; // Initialize the first row of the DP table
            if (arr[0] <= k)  prev[arr[0]] = true;     // Initialize the first column of the DP table
            for (int ind = 1; ind < n; ind++) { // Fill in the DP table using bottom-up dynamic programming
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notTaken = prev[target];
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = prev[target - arr[ind]];
                    }
                    cur[target] = notTaken || taken;  // Update the DP table for the current element and target sum
                }
                // Update the previous row with the current row for the next iteration
                prev = cur;
            }
            // The result is stored in the last cell of the DP table
            return prev[k];
    }
}
