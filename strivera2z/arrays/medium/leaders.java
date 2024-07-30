Problem Statement: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.

brute: 2loops.
 ArrayList<Integer> ans= new ArrayList<>();
  
  for (int i = 0; i < n; i++) {
    boolean leader = true;

    //Checking whether arr[i] is greater than all 
    //the elements in its right side
    for (int j = i + 1; j < n; j++)
      if (arr[j] > arr[i]) {
          
        // If any element found is greater than current leader
        // curr element is not the leader.
        leader = false;
        break;
      }

    // Push all the leaders in ans array.
    if (leader)
    ans.add(arr[i]);

  }
  
  return ans;
tc: o(n^2) . sc:o(n).

optimal: check from back.
   
  ArrayList<Integer> ans= new ArrayList<>();
  
   // Last element of an array is always a leader,
   // push into ans array.
   int max = arr[n - 1];

    ans.add(arr[n-1]);
    
    // Start checking from the end whether a number is greater
    // than max no. from right, hence leader.
    for (int i = n - 2; i >= 0; i--)
      if (arr[i] > max) {
        ans.add(arr[i]);
        max = arr[i];
      }

  return ans;

tc:o(n) . sc:o(n),
