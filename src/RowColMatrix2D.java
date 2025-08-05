import java.util.Arrays;

public class RowColMatrix2D {
    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        int target = 39;

        System.out.println(Arrays.toString(search2D(mat, target)));


    }

    public static int[] search2D(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length-1; // start from last col


        while (r < matrix.length && c >= 0){

                if(matrix[r][c] == target){
                    return new int[] {r, c};
                }

                if(matrix[r][c] < target){
                    r++;
                }else{
                    c--;
                }
        }

        return new int[]{-1, -1};

    }
}
