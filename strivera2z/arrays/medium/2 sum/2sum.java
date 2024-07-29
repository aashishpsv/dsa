Problem Statement: Given an array of integers arr[] and an integer target.

1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

//brute: tc:O(n^2)(2 loops). sc:o(1).

for(int i=0;i<n;i++){
  for(int j=i;j<n;j++){
    if(arr[i]+arr[j]==target){
    return new int[]{i,j}; }
  }
}

//better: hashing tc:o(n) , sc(o(n)) , n the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the time complexity will be O(N2). 
//If we use map instead of unordered_map, the time complexity will be O(N* logN) as the map data structure takes logN time to find an element.
 HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
             return new int[]{ I, mpp.get(moreNeeded};}
            mpp.put(arr[i], i);  }
   return ans;
    }

//best :  2 pointers. from 0 and n-1. sum of s[left] + s[right] . if s<target: left++ s > target : right--;
 Arrays.sort(arr);
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left,right};;
            } else if (sum < target) left++;
            else right--;
        }
                return new int[]{-1,-1};
    }
