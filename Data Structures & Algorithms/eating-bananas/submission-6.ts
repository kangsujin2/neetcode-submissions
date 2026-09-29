class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
    minEatingSpeed(piles: number[], h: number): number {

       let left = 1;
       let right = 0;

       for (const pile of piles) {
        right = Math.max(right, pile);
       }

       while (left < right) {
        const mid = Math.floor((left+right)/2);
        let hours = 0;

        for (const pile of piles) {
            hours += Math.ceil(pile/mid);
        }

        if (hours <= h) right = mid;
        else left = mid + 1;
       }

       return left;
    }
}
