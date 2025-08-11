import java.util.Arrays;

//167. Two Sum II - Input Array Is Sorted
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

public class TwoSum2InSortedArray {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumOptimal(numbers, target)));

    }

    //    Brute Force Approach
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{-1, -1};

    }

    //    Optimal approach using binary search
    public static int[] twoSumOptimal(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
//            current sum

            int currentSum = numbers[left] + numbers[right];

//            if currentSum == target, return indices with +1
            if (currentSum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (currentSum < target) {
//                if current sum is less than target, increase left
                left++;
            } else {
//                if current sum is greater than target, decrease right
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
