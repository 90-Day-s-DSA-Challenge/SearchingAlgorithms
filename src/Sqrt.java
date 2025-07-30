public class Sqrt {
//    69. Sqrt(x)
//    https://leetcode.com/problems/sqrtx/description/
    public static void main(String[] args) {
        int x = 4;
        System.out.println(mySqrt(x));

    }

    public static int mySqrt(int x) {
        if(x < 2){
            return x;
        }

        int start = 1;
        int end = x;
        int result = 0;

        while(start <= end){
            int mid = start + (end- start) / 2;

            long square = (long) mid * mid; // used to prevent overflow

            if(square == x){
                return mid;
            }else if(square < x){
                result = mid;
                start = mid+1;
            }else{
                end =  mid-1;
            }
        }

        return result;
    }
}

/**
 Example: x = 10
 Binary search steps:

 mid = 5, 5*5 = 25 > 10 → too big

 mid = 2, 2*2 = 4 < 10 → store 2, go right

 mid = 3, 3*3 = 9 < 10 → store 3, go right

 mid = 4, 4*4 = 16 > 10 → too big

 Done. Best valid result stored = 3.

 Return result = 3.

 */
