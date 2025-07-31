public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        int n = 10;
        int target = 6;

        System.out.println(guessNumber(n, target));
    }
    public static int guessNumber(int n, int target) {
        int start = 1;
        int end = n;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target > mid){
                end = mid-1;
            }else if(target < mid){
                start = mid+1;
            }else{
                return mid;
            }
        }

        return -1;

    }
}

/**
 This will not working
 */