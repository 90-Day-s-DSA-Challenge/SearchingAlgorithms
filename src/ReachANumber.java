public class ReachANumber {
    public static void main(String[] args) {
        System.out.println(reachNumberOptimal(-30));
//        System.out.println(reachNumber(1234234523));

    }

    public static int reachNumber(int target){
        int step=0;

        int count = 0;
        target = Math.abs(target);
//        System.out.println("abs "+target);

        while (count < target || (count-target) %2 != 0){
//            System.out.println((count-target) %2 != 0);
            step++;
            count += step;
        }

        return  step;
    }

    /**
     Mathematical Shortcut Optimization (Optional and Overkill)
     You can calculate the initial value of step using the formula for the sum of first n numbers:

     sum = 𝑛(𝑛+1)/2

     This can give a starting point and reduce loop iterations.
     */
    public static int reachNumberOptimal(int target) {

        // absolute val
        target = Math.abs(target);

        // Start with estimated step using quadratic formula
        int step = (int) (Math.ceil((-1 + Math.sqrt(1 + 8.0 * target)) / 2));

        int sum = step * (step + 1) / 2;

        // If difference is odd, keep increasing step until difference becomes even
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }

        return step;

    }
}
