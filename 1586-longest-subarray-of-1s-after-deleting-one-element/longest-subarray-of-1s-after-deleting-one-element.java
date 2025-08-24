class Solution {
    public int longestSubarray(int[] nums) {
        int prev = 0, curr = 0, res = 0;
        for(int i : nums){
            if(i == 1)
                curr++;
            else{
                res = Math.max(res, prev + curr);
                prev = curr;
                curr = 0;
            }
        }
        return Math.min(Math.max(res, prev + curr), nums.length -1);
        
        }
        
    }
