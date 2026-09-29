class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int lm = height[l];
        int rm = height[r];
        int w = 0;

        while (l< r) {
            if (lm < rm) {
                l++;
                w += Math.max(lm - height[l], 0);
                lm = Math.max(lm, height[l]);
            } else {
                r--;
                w += Math.max(rm - height[r], 0);
                rm = Math.max(rm, height[r]);
            }
        }

        return w;
    }
}
