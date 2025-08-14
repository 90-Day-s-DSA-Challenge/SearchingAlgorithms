public class KokoEatingBananas {
    //    875. Koko Eating Bananas
//    https://leetcode.com/problems/koko-eating-bananas/description/
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));

    }

    //    STEP 01: find max val
    private static int findMax(int[] piles) {
        int maxVal = 0;

        for (int x : piles) {
            maxVal = Math.max(maxVal, x); // compare and return max
        }

        return maxVal;
    }

    //    STEP 02: find total calculated hour of eating piles
    private static long calculateTotalHours(int[] piles, int mid) {
        long totalHour = 0;

        for (int i = 0; i < piles.length; i++) {
//            calculate all the hours
            totalHour += Math.ceil((double) (piles[i]) / (double) (mid));
        }

        return totalHour;
    }

    //    STEP 00: Find Min Eating Speed
    public static int minEatingSpeed(int[] piles, int h) {
//        STEP 01
        int min = 1;
        int max = findMax(piles);

//        Binary search because in that case have range problem
        while (min <= max) {
            int mid = min + (max - min) / 2;

//            find hourly it can be large number so take long
            long totalHour = calculateTotalHours(piles, mid);


            // Binary Search transpose
            // If totalHours <= h, the current speed (mid) works, but we might be able to eat slower.
            // So we move the upper bound left to search for a smaller valid speed.
            // If totalHours > h, the current speed is too slow, so we move the lower bound right
            // to search for a faster speed.
            if (totalHour <= h) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }


}
