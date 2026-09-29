class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length-1;


        while (top <= bot) {
            int mid = top + (bot - top)/2;

            if (target < matrix[mid][0]) {
                bot = mid - 1;
            }
            else if (target > matrix[mid][matrix[0].length-1]) {
                top = mid + 1;
            }
            else {
                int l = 0;
                int r = matrix[0].length-1;
                while (l <= r) {
                    int m = l + (r - l)/2;
                    if (matrix[mid][m] == target) return true;
                    else if (matrix[mid][m] < target) l = m + 1;
                    else r = m - 1;
                }

                return false;
            }
        }

        return false;
    }
}
