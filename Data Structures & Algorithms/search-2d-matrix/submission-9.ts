class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    searchMatrix(matrix: number[][], target: number): boolean {
        if (matrix.length === 0 || matrix[0].length === 0) {
            return false;
        }

        const cols = matrix[0].length;
        let top = 0;
        let bottom = matrix.length - 1;

        while (top <= bottom) {
            const row = Math.floor((top + bottom) / 2);

            if (target < matrix[row][0]) {
                bottom = row - 1;
            } else if (target > matrix[row][cols - 1]) {
                top = row + 1;
            } else {
                let left = 0;
                let right = cols - 1;

                while (left <= right) {
                    const col = Math.floor((left + right) / 2);
                    const value = matrix[row][col];

                    if (value === target) return true;

                    if (value < target) {
                        left = col + 1;
                    } else {
                        right = col - 1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
