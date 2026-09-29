class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int l = 1;
        int r = maxPile;

        while (l < r) {
            int t = 0;
            int m = l + (r - l)/2;
            for (int p : piles) {
                t += Math.ceil((double)p/m);
            }
            if (t <= h) r = m;
            else l = m + 1;
        }

        return l;
    }
}
