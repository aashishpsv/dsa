class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int no : nums) total +=no;
        int r=0,l=0;
       for(int i=0;i<nums.length;i++){
        r = total-nums[i]-l;
        if(r==l) return i;
        l +=nums[i];
         

       } 
       return -1;
    }
}