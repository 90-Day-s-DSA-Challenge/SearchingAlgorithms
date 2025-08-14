public class FindKthPositive {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        System.out.println(findKthPositive(arr, k));

    }

    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int missingCount = arr[mid] - (mid + 1);

            // arr = [2, 3, 4, 7, 11]
            // Index: 0   1   2   3   4
            // Value: 2   3   4   7   11
            // Expected (if no missing): 1  2  3  4   5
            // missingCount at mid=3: 7 - (3+1) = 7 - 4 = 3
            // → There are 3 missing numbers before index 3. go to next iteration, so on.

            if (missingCount < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start + k;
    }
}
