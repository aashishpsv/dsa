class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length,i=0;
        List<int[]> result = new ArrayList<>();
        //1
        while(i<n && intervals[i][1]<newInterval[0]){ result.add(intervals[i]);i++;}
        //2
        while(i<n && newInterval[1] >=intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        //3
        while(i<n){ result.add(intervals[i]);i++;}
        return result.toArray(new int[result.size()][]);

    
    }
}