sort 0,1,2 in array

//brute: sort. tc:o(nlogn) sc;0(1)
public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

//better: store all counts and iterate again 
public void sortColors(int[] nums) {
       int z=0,o=0,t=0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==0)z++;
        if(nums[i]==1)o++;
        if(nums[i]==2)t++;
       }
       int j=0;
       while(j<z){nums[j]=0;j++;}
       while(j<z+o){nums[j]=1;j++;}
       while(j<nums.length){nums[j]=2;j++;}
}
//tc: o(n)+o(n).  sc:o(1).

//optimal: dutch national flag.This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:
// arr[0….low-1] contains 0. [Extreme left part]
// arr[low….mid-1] contains 1.
// arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
// The middle part i.e. arr[mid….high] is the unsorted segment
 public static void sortArray(ArrayList<Integer> arr, int n) {
        int low = 0, mid = 0, high = n - 1; // 3 pointers

        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;

            } else if (arr.get(mid) == 1) {
                mid++;

            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high--;
            }
        }
//tc: o(n) sc:o(1)

best:
 public void sortColors(int[] nums) {
        int a0=0,a1=0,a2=0;
        for(int i : nums){
            nums[a2++] = 2; 
            if(i<=1){nums[a1++]=1;}
            if(i==0){ nums[a0++]=0;}
        }
    }
