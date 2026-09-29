class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int k = r;

        while (l<=r) {

            long totalTime = 0;
            int m = l + (r-l)/2;
            for (int pile : piles) {
                totalTime += Math.ceil((double) pile/m);
            }

            if (totalTime <= h) {
                k = m;
                r = m-1;
            }
            else {
                l = m+1; 
            }
            
        }

        return k;
    }
}
