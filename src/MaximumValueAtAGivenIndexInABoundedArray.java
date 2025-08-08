public class MaximumValueAtAGivenIndexInABoundedArray {
    //    1802. Maximum Value at a Given Index in a Bounded Array
//    https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/
    public static void main(String[] args) {
        System.out.println(maxValue(6, 1, 10));

    }

    //    Brute Force Approach
    public static int maxValue(int n, int index, int maxSum) {
        int start = 1;
        int end = maxSum;

//        left = 1
//        right = 15


        while (start < end) {
            // Calculate midpoint and avoid integer overflow

//            mid = (1 + 15 + 1) >>> 1
//            mid = 8

            int mid = (start + end + 1) >>> 1;

//            int mid = start + (end - start) / 2;
//            System.out.println("mid " + mid);

            // If the calculated sum is within the allowed range, search in the upper half

            if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
//                (sum of left half + mid + sum of right half) <= maxSum
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static long sum(long x, int count) {
        /**
         x = starting value for that side,
         count = how many elements on that side.
         */

//        CASE 01: x >= count
        /**
         Example: x = 5, count = 3
         Side values: 5, 4, 3
         Sum = (5 + 3) * 3 / 2 = 12

         Formula:
         (x + (x - count + 1)) * count / 2
         i.e (first_term + last_term) * number_of_terms / 2


         */

//        CASE 02: x < count
        /**
         Example: x = 3, count = 5
         Side values: 3, 2, 1, 1, 1
         Sum = (3+2+1) + (remaining ones)
         Sum = (3 * 4 / 2) + (5 - 3)

         Formula:
         Triangular sum up to x + (count - x)
         = (x + 1) * x / 2 + (count - x)

         */

//        if (x >= count) {
//            // If 'x' is greater than 'count', we can simply calculate a triangular sum
//            return (x + x - count + 1) * count / 2;
//        } else {
//            // Otherwise, we calculate the triangular sum up to 'x' and add the remaining
//            // 'count - x' ones (since we cannot decrement below 1)
//            return (x + 1) * x / 2 + count - x;
//
//        }

        return x >= count ? (x + x - count + 1) * count / 2 : (x + 1) * x / 2 + count - x;

    }
}

/**
 * Step 3 — Check with sum()
 * Left side:
 * sum(mid - 1, index) = sum(7, 2)
 * That means: start from 7, length 2.
 * <p>
 * x = 7, count = 2
 * <p>
 * Since x >= count, use triangular sum formula:
 * <p>
 * (7 + (7 - 2 + 1)) * 2 / 2
 * = (7 + 6) * 2 / 2
 * = 13 * 2 / 2
 * = 13
 * <p>
 * Left sum = 13.
 * <p>
 * Right side:
 * sum(mid, n - index - 1) = sum(8, 3)
 * That means: start from 8, length 3.
 * <p>
 * x = 8, count = 3
 * <p>
 * x >= count:
 * <p>
 * <p>
 * (8 + (8 - 3 + 1)) * 3 / 2
 * = (8 + 6) * 3 / 2
 * = 14 * 3 / 2
 * = 21
 * Right sum = 21.
 * <p>
 * Total sum:
 * Left  = 13
 * Middle element = 8
 * Right = 21
 * <p>
 * Total = 13 + 8 + 21 = 42
 * Way bigger than maxSum = 15, so mid = 8 is too large.
 */
