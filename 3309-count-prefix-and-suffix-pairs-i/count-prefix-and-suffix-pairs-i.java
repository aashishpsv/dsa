class Solution {
     
    // private boolean checkprefix(String str1, String str2) {
    //     return str2.startsWith(str1);
    // }
 // private boolean checksuffix(String str1, String str2) {
    //     return str2.endsWith(str1);
    // }

    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;

        for (int i=0;i<words.length-1;i++){
            String cur = words[i];
            for(int j=i+1;j<words.length;j++){
                String cur1 = words[j];
                //version1 // if(checkprefix(cur,cur1)){ if(checksuffix(cur,cur1)) ans++; }
                
               //version 2// if(cur1.startsWith(cur) && cur1.endsWith(cur)) ans++;

               if(checkprefix(cur,cur1)){ if(checksuffix(cur,cur1)) ans++; }
              

            }
        }
        return ans;
    }

    private boolean checkprefix(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false; 
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false; 
            }
        }
        return true; 
    }

    private boolean checksuffix(String str1, String str2) {
       
        if (str1.length() > str2.length()) {
            return false;
        }
        int str1Len = str1.length();
        int str2Len = str2.length();
        for (int i = 0; i < str1Len; i++) {
            if (str1.charAt(str1Len - 1 - i) != str2.charAt(str2Len - 1 - i)) {
                return false; 
            }
        }
        return true; 
    }
}