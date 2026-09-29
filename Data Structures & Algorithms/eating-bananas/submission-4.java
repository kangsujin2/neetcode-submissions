class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int p : piles) {
            maxPile = Math.max(maxPile, p);
        } 

        int l = 1;
        int r = maxPile;
        int res = r;

        while (l<=r) {
            int m = l + (r-l)/2;

            int t = 0;
            for (int p : piles) {
                t += Math.ceil((double)p/m);
            }

            if (t <= h) {
                res = m;
                r = m-1;
            } else {
                l = m+1;
            }
            
        }
        return res;
    }
}
