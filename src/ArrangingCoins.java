public class ArrangingCoins {
    //    441. Arranging Coins
//    https://leetcode.com/problems/arranging-coins/description/
    public static void main(String[] args) {
        System.out.println(arrangeCoinsFaster(5));

    }

    //    Iterative approach
    public static int arrangeCoins(int n) {
        int i = 1;

        while (n > 0) {
            i++;
            n = n - i;
        }

        return i - 1;
    }

    //    binary search and better approach
    public static int arrangeCoinsBinarySearch(int n) {
        long start = 0;
        long end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            /**
             That formula:
             Is the triangular number formula (sometimes called the sum of the first n natural numbers formula).
             */
//            this is required formula used to calculate the
            long coinUsed = mid * (mid + 1) / 2;

            if (coinUsed == n) {
                return (int) mid;
            }

            if (coinUsed < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) end;
    }

    //    Direct Formula approach
    public static int arrangeCoinsFaster(int n) {
        return (int) ((Math.sqrt(1 + 8L * n) - 1) / 2);
    }
}
