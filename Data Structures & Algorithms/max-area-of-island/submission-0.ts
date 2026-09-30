class Solution {
    /**
     * @param {number[][]} grid
     * @return {number}
     */
    maxAreaOfIsland(grid: number[][]): number {
        if (grid.length === 0) return 0;

        const rows = grid.length;
        const cols = grid[0].length;
        let maxArea = 0;
        

        function dfs(row: number, col: number): number {
            if (
                row < 0 || row >= rows ||
                col < 0 || col >= cols ||
                grid[row][col] !== 1
            ) {
                return 0;
            }

            grid[row][col] = 0; 

            return (
                1 +
                dfs(row - 1, col) +
                dfs(row + 1, col) +
                dfs(row, col - 1) +
                dfs(row, col + 1)
            );
        }

        for (let row = 0; row < rows; row++) {
            for (let col = 0; col < cols; col++) {
                if (grid[row][col] === 1) {
                    const area = dfs(row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }

        }

        return maxArea;
    }
    
}
