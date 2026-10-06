class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
    minEatingSpeed(piles: number[], h: number): number {
        let min = 1;
        let max = 0;

        for (const pile of piles) {
            max = Math.max(max, pile);
        }

        while (min < max) {
            let speed = Math.floor((min + max) / 2);
            let hours = 0;

            for (const pile of piles) {
                hours += Math.ceil(pile / speed);
            }
            if (hours <= h) {
                max = speed;
            } else {
                min = speed + 1;
            }
        }

        return min;
    }
}
