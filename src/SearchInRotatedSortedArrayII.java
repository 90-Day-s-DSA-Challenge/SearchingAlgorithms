public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 5;

        System.out.println(search(nums, target));


    }

    public static boolean search(int[] nums, int target) {
        int pivot  = findPivot(nums);

//        CASE 00: if pivot is -1 i.e array is not rotated so just do simple binary search
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1) != -1 ? true :false;
        }

//        CASE 01: if pivot == target, target found
        if(nums[pivot] == target){
            return true;
        }

//        CASE 02: target is greater then start
        if(target >= nums[0]){
            // int res = binarySearch(nums, target, 0, pivot-1);
            // if(res != -1){
            return binarySearch(nums, target, 0, pivot-1) != -1 ?true:false;
            // }
        }

//        CASE 03: target is less then start

        return binarySearch(nums, target, pivot+1, nums.length-1) != -1 ? true:false;

    }

    //    binary search
    static  int binarySearch(int[] arr, int target, int start, int end){
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
   static int findPivot(int[] arr){
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
            // remove ducplicate
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                // check manually if start or end is equal to pivot
                if(start < end && arr[start] > arr[start+1]){
                    return start;
                }
                start++;

                if(end > start && arr[end-1] > arr[end]){
                    return end - 1;
                }
                end--;
            }
            // left side is unsorted move left
            else if(arr[start] > arr[mid]){
                end = end -1;
            }
            // right side is unsorted move right
            else{
                start = mid + 1;
            }

        }
        return -1;
    }
}
