import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        // sorting given interval
        Arrays.sort(intervals, new Comparator<int[]>(){  // nlogn
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<>();

        for(int i = 0; i < size; i++){         //O(2n) each interveal is visited twice bcoz of continue and break it's not n^2.
            int start = intervals[i][0];
            int end = intervals[i][1];

            // skipping all merged intervals
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1)[1]) continue;  // checking with last added interval

            for(int j = i+1; j < size; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(intervals[j][1],end);    // update end 
                }
                else{
                    break;
                }
            }

            ans.add(new int[] {start,end});
        }
        return ans.toArray(new int[ans.size()][]);  // converting list of array to 2d array
    }
}