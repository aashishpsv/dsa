class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int i = size-1;

        while(i>=0){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
            i--;
        }
        int[] newD = new int[size+1];
        newD[0] = 1;
        return newD;
      /*  if(digits[size-1]!=9){
            digits[size-1] +=1;
          return digits;
        }
        else{
            int x = size-1;
            while(x>=0){
                if(digits[x] <9){
                    digits[x]++;
                    return digits;
                }
                digits[x]=0;
                x--;
            }
           }
        int[] newD = new int[size+1];
        newD[0] = 1;
        return newD; */
        }
    }
