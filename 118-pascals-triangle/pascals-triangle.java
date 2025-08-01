class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(rowgen(i));
        }
        return ans;
        
        
    }
    public static List<Integer> rowgen(int rowno){
        long ans=1;
         List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int col=1;col<rowno;col++){
            ans = ans *(rowno- col)/col;
            row.add((int)ans);
        }
        return row;
        
    }

}