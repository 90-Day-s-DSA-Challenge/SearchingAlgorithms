import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public static void main(String[] args) {
        int[][] intervals = {{3, 4},{2, 3},{1, 2}};

        int[] result = findRightInterval(intervals);

        System.out.println(Arrays.toString(result));

    }

    public static int[] findRightInterval(int[][] intervals){
        int n = intervals.length;

//        Create a array to store the original index of interval
//        [start_i, end_i, original_index]
        int[][] indexedIntervals =  new int[n][3];

//        Now run a loop to store original index
        for(int i = 0; i < n; i++){
            indexedIntervals[i][0] = indexedIntervals[i][0];
            indexedIntervals[i][1] = indexedIntervals[i][1];
            indexedIntervals[i][2] = i;
        }

//        Sort by start time
        Arrays.sort(indexedIntervals, Comparator.comparing(a -> a[0]));

        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            int targetEnd = intervals[i][1];

//            binary search
            int start = 0;
            int end = n - 1;
            int rightIntervalIndex = -1;

            while(start <= end){
                int mid = start + (end - start) / 2;

                if(indexedIntervals[mid][0] >= targetEnd){
                    rightIntervalIndex = indexedIntervals[mid][2]; // found
                    end = mid - 1;
                }else{
                    start = mid +1;
                }
            }

            result[i] = rightIntervalIndex;
        }

        return result;


    }
}
