public class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        int[] nums1 = {1, 10, 4, 4, 2, 7};
        int[] nums2 = {9, 3, 5, 1, 7, 4};

        System.out.println(minAbsoluteSumDiff(nums1, nums2));

    }

//    Input: nums1 = [1,7,5], nums2 = [2,3,5]
//    Output: 3
//    Explanation: There are two possible optimal solutions:
//    - Replace the second element with the first: [1,7,5] => [1,1,5], or
//    - Replace the second element with the third: [1,7,5] => [1,5,5].
//    Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int min = 1;
        int max = 0;
        int minSum = 0;

//        find max in
        for (int x : nums1) {
            max = Math.max(max, x);
        }

        for (int i = 0; i < nums1.length; i++) {
            minSum += Math.abs(nums1[i] - nums2[i]);
            System.out.println(minSum);
        }

        return Math.abs(minSum);


    }
}
