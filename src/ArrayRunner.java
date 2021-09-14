import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class ArrayRunner {
    public static void main(String args[]){
        ArrayRunner runner = new ArrayRunner();
        runner.getMergedList(runner.getTestData());
    }
    public int[][] getMergedList(int[][] intervals){
        // Sort the intervals
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        // Compare the start time of next interval and end time of current to check if merge can happen
        List<int[]> mergedList = new ArrayList<>();
        int i=0;
        for(int[] interval:intervals){
            if(mergedList.isEmpty() || interval[0] < mergedList.get(i-1)[1]){
                mergedList.add(interval);
                i++;
            }else{
                if(interval[0] < mergedList.get(i-1)[1]){
                    // perform merge
                    mergedList.get(i-1)[1]=Math.max(mergedList.get(i-1)[1],interval[1]);
                }
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
    public int[][] getTestData(){
        int [][] intervals = new int[3][2];
        intervals[0][0]=1;
        intervals[0][1]=3;
        intervals[1][0]=2;
        intervals[1][1]=4;
        intervals[2][0]=1;
        intervals[2][1]=2;
        return intervals;
    }
}
