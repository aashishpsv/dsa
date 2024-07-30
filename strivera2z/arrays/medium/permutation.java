1.brute:recursion. find ds + swap (see video)

2. c++ fn

3.1)find bp from back where arr[i] < arr[i+1].
next swap arr[bp] with smallest ele on its right hand side.
next reverse the part from bp+1 to n-1.

ex: [1,4,5,3,2] -> bp = 4 is 4< 5. so swap 4 and 5. -> [1,5,4,3,2] . so next reverse from bp+1 to n-1 ie 4 to 2. -> [1,5,2,3,4]. so ans obtained.

code:
{
int n = A.size(); // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }

        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        // Step 3: reverse the right half:
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
}
