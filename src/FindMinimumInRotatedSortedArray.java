public class FindMinimumInRotatedSortedArray {
//    153. Find Minimum in Rotated Sorted Array
//    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));

    }

    public static int findMin(int[] arr){
        int start = 0;
        int end = arr.length-1;

//        if array is not rotated and end > start then first element is min val
        if(arr[end] > arr[start]){
            return arr[start];
        }

        while (start < end){
            int mid = start + (end - start) / 2;

//            CASE 01: mid > mid + 1 , here mid will less than end  mid < end
            if(mid < end && arr[mid] > arr[mid+1]){
//                return after pivot value, i.e min
                return arr[mid+1];
            }

//            CASE 02: mid-1 > mid, here mid will be greater than start, mid > start
            if(mid > start && arr[mid-1] > arr[mid]){
                return arr[mid];
            }

//            CASE 03: Iterate
//            [4,5,6,7,0,1,2, 3]
            if(arr[mid] >= arr[start]){
                start = mid +1;
            }else{
                end = mid;
            }

            /**
              {4, 5, 6, 7, 0, 1, 2}
               S.       M.       E

             Case 03: arr[mid] >= arr[start], 7 >= 4, true
                    s = mid + 1

             [7, 0, 1, 2]
             S.  M.    E

            Case 03: arr[mid] >= arr[start], 0 >= 7,  false
                    end = mid
             [7,    0]
             S,M   E

             Case 01: arr[mid] > arr[mid+1]
                    largest = 7, i.e min val will be arr[mid+1] which is 0

             */
        }

//        if not found then return start
        return arr[start];
    }
}
