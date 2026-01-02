class Solution {
    public int repeatedNTimes(int[] nums) {
        int x = nums.length/2;
       Arrays.sort(nums);
       for(int i=0;i<x*2;i++){
        if(nums[i+1]-nums[i] == 0)return nums[i+1];
       }

       return 0;
    }
}