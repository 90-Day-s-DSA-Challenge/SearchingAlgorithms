public class ValidPerfectSquare {
//    367. Valid Perfect Square
//    https://leetcode.com/problems/valid-perfect-square/description/

    public static void main(String[] args) {
        int num = 725;
        System.out.println(isPerfectSquare(num));
    }

    //    Optimal solution using binary search
    private static boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;

//        if num is less than 2 then return true
        if (num < 2) return true;

        while (start < end) {
            int mid = start + (end - start) / 2;
            long sqr = (long) mid * mid; // mid = 4, 4*4 = 16 == target, true

            if (sqr == num) {
                return true;
            }

            if (sqr < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return false;
    }
}
