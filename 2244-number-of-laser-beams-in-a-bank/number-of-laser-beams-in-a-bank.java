class Solution {
    public int numberOfBeams(String[] bank) {

        int n=bank.length;
        int []laser = new int[n];
        Arrays.fill(laser,0);
        int tot = 0;
        int i=0;
        for(String no : bank){
            int x = countones(no);
            if(x!=0) laser[i++]=x;
        }
        int j=0;
        for (j = 0; j < n - 1 && laser[j] != 0; j++) {
    tot += laser[j] * laser[j + 1];
}

        return tot;
        }
        
    public int countones(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '1') {
            count++;
        }
    }
    return count;
}

}