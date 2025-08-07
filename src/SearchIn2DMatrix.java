import java.util.ArrayList;
import java.util.Arrays;

//https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/

public class SearchIn2DMatrix {
    public static void main(String[] args) {
//        int[][] mat = {
//                {10, 20, 30, 40},
//                {15, 25, 35, 45},
//                {28, 29, 37, 49},
//                {33, 34, 38, 50}
//        };

        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        mat.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        mat.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        mat.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
        mat.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));

        int target = 15;

        System.out.println(optimalSearch(mat, target));

    }

//    Brute Force Approach
//    iterate each row to find target
    public static boolean search(ArrayList<ArrayList<Integer>> matrix, int target){
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix.get(i).get(j) == target){
                    return true;
                }
            }
        }

        return false;
    }


//    better approach ==> Binary Search
    /**
     Algorithm:

     1. We will use a loop(say i) to select a particular row at a time.

     2. Next, for every row, i, we will check if it contains the target.

     3. If matrix[i][0] <= target && target <= matrix[i][m-1]: If this condition is met, we can conclude that row i has the possibility of containing the target.

     4. So, we will apply binary search on row i, and check if the ‘target’ is present. If it is present, we will return true from this step. Otherwise, we will return false.

     5. Otherwise, after completing the traversal, we will return false.
     */

    public static boolean betterSearch(ArrayList<ArrayList<Integer>> matrix, int target){
        int n = matrix.size();

        for(int i = 0; i < n; i++){
            if(matrix.get(i).get(0) <= target && target <= matrix.get(i).get(n-1)){
                return binarySearch(matrix.get(i), target);

            }
        }

        return false;
    }

    public static boolean binarySearch(ArrayList<Integer> nums, int target){
        int start = 0;
        int end = nums.size()-1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(nums.get(mid) == target) return true;

            if(nums.get(mid) < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

//    optimal approach
    /**

     Algorithm:

         1.Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 0 and the high will point to (NxM)-1.

         2. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
                mid = (low+high) // 2 ( ‘//’ refers to integer division)

         3. Eliminate the halves based on the element at index mid: To get the element, we will convert index ‘mid’ to the corresponding cell using the above formula. Here no. of columns of the matrix = M.
               row = mid / M, col = mid % M.
                 If matrix[row][col] == target: We should return true here, as we have found the ‘target’.
                 If matrix[row][col] < target: In this case, we need bigger elements. So, we will eliminate the left half and consider the right half (low = mid+1).
                 If matrix[row][col] > target: In this case, we need smaller elements. So, we will eliminate the right half and consider the left half (high = mid-1).

         4.Steps 2-3 will be inside a while loop and the loop will end once low crosses high
         (i.e. low > high). If we are out of the loop, we can say the target does not exist in the matrix. So, we will return false.
     */

    public static boolean optimalSearch(ArrayList<ArrayList<Integer>> matrix, int target){
        int n = matrix.size();
        int m = matrix.get(0).size();

        int start = 0;
        int end = n * m -1; // (3 * 3)-1 = 9-1 = 8, total 8 index

        while (start <= end){
            int mid = start + (end - start) / 2;

//            matrix.get(row).get(col) i.e matrix[1][1]
            int row = mid / m; // (5 / 4) = 1
            int col = mid % m; // (5 % 4) = 1

            if(matrix.get(row).get(col) == target) return true;

            if(matrix.get(row).get(col) < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

}
