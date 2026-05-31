package BinarySearch.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q436_Find_Right_interval {
    static void main(String[] args) {

        int[][] intervals = {
                {3,4} , {2,3}, {1,2}
        };
        int[] ans = findRightIntervals(intervals);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] findRightIntervals(int[][] intervals) {

        int ans[] = new int[intervals.length];
        int startIntervals[] = new int[intervals.length];

        for(int i=0; i<intervals.length; i++)
        {
            startIntervals[i] = intervals[i][0];
        }

        Map<Integer, Integer> startIndex = new HashMap<>();
        for(int i=0; i<intervals.length; i++)
        {
            startIndex.put( startIntervals[i] , i );
        }


        Arrays.sort(startIntervals);

        for(int i=0; i<intervals.length; i++)
        {
            int findElement = helper(startIntervals, intervals[i][1]);

            if(findElement == -1){
                ans[i] = -1;
            }else{
                ans[i] = startIndex.get(startIntervals[findElement]);
            }

        }
        return ans;
    }
    public static int helper(int[] startIntervals, int target){

        int low= 0;
        int high = startIntervals.length-1;

        int findNum = -1;

        while(low <= high)
        {
            int mid = low + (high-low)/2;

            if(startIntervals[mid] == target)
            {
                return mid;
            }
            else if(startIntervals[mid] > target){
                findNum = mid;
                high =  mid-1;
            }else{
                low = mid+1;
            }
        }
        return findNum;
    }
}
