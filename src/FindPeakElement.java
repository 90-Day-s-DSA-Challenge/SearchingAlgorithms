public class FindPeakElement {
//    162. Find Peak Element
//    https://leetcode.com/problems/find-peak-element/description/?envType=problem-list-v2&envId=binary-search
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeak(nums));

    }

    public static int findPeak(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[mid+1]){
                //  you are in decreasing part of an array
                //  this may be the answer, but look at left
                //  this is why end != mid - 1
                end = mid;
            }else{
//                you are in increasing part of an array
                start = mid +1; // because we know that mid+1 > mid
            }
        }

//        in the end, start == end and pointing to the largest number because of the checks above
//        start and end are always trying to find max element in the above 2 checks
//        hence, when they are pointing to just one element, that is the maximum one, because that is what checks says

//        more elaboration: at every point of time for start and end, they have the best possible answer till that time
//        and if we are saying that only one item is remaining, hence cuz of above line that is the best possible answer

//        we can return start or end because both are same (start == end)
        return start;
    }
}
