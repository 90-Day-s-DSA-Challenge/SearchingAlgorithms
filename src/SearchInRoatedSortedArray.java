public class SearchInRoatedSortedArray {
//    33. Search in Rotated Sorted Array
//    https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        System.out.println(search(nums, target));
    }

//    search number
    public static int search(int[] arr, int target){
        int pivot  = findPivot(arr);

//        CASE 00: if pivot is -1 i.e array is not rotated so just do simple binary search
        if(pivot == -1){
           return binarySearch(arr, target, 0, arr.length-1);
        }

//        CASE 01: if pivot == target, target found
        if(arr[pivot] == target){
            return pivot;
        }

//        CASE 02: target is greater then start
        /**
         nums = {4, 5, 6, 7, 0, 1, 2}
         target = 6

         target > nums[0] :
                that means target must be present in left side of the rotated array

         i.e. start = 0, end = pivot-1. (we use pivot-1 because we have already check if pivot==target then its return)

         */
        if(target >= arr[0]){
            return binarySearch(arr, target, 0, pivot-1);
        }


//        CASE 03: target is less then start
        /**
         nums = {4, 5, 6, 7, 0, 1, 2}
         target = 1

         target < nums[0] :
         that means target must be present in right half of the rotated array

         i.e. start = pivot+1, end = nums.length-1.

         */

//        if(target < arr[0]){
            return binarySearch(arr, target, pivot+1, arr.length-1);
//        }


    }


//    binary search
    public static int binarySearch(int[] arr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

//    find pivot point => largest number in array
//    return index of pivot point
    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start < end){
            int mid = start + (end - start) / 2;

//            on finding pivot there is 4 cases
//            CASE 01: Found the pivot, because mid element is greate than mid + 1.
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }

//            CASE 02: mid element is smaller than prev element mid < mid - 1
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }

//            CASE 03 & 04: Narrow down the search
            if(arr[mid] <= arr[start]){
//                search in left hal
                end = mid-1;
            }else{
//                search in right half
                start = mid+1;
            }

        }
        return -1;
    }


}
