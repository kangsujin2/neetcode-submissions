class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;

        int max = 0;

        while(l<r) {
            int lw = heights[l];
            int rw = heights[r];
            max = Math.max(max, (r-l) * (Math.min(lw, rw)));
            if (lw < rw) {l++;}
            else if (lw > rw) {r--;}
            else {l++; r--;}
        }

        return max;
    }
}
