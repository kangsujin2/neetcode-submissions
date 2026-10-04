class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    searchMatrix(matrix: number[][], target: number): boolean {
        if (matrix.length === 0 || matrix[0].length === 0) return false;

        const cols = matrix[0].length;

        let left = 0;
        let right = matrix.length * cols - 1;

        while (left <= right) {
            let mid = Math.floor((left + right) / 2);

            let row = Math.floor(mid / cols);
            let col = mid % cols;

            let value = matrix[row][col];

            if (value === target) return true;

            if (value < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
