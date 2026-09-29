class Solution {
    /**
     * @param {number[]} heights
     * @return {number}
     */
    maxArea(heights: number[]): number {
        let left = 0;
        let right = heights.length - 1;
        let max = 0; 

        while (left<right) {
            let water = (right-left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, water);

            if (heights[left]<heights[right]) left++;
            else right--;
        }

        return max;
    }
}
