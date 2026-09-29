class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int m = l + (r - l)/2;

            int row = m / matrix[0].length;
            int col = m % matrix[0].length;

            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) r = m - 1;
            else l = m + 1;
        }

        return false;
    }
}
