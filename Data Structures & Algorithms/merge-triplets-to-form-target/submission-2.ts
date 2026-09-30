class Solution {
    /**
     * @param {number[][]} triplets
     * @param {number[]} target
     * @return {boolean}
     */
    mergeTriplets(triplets: number[][], target: number[]): boolean {
        let foundFirst = false;
        let foundSecond = false;
        let foundThird = false;

        for (const triplet of triplets){
            if (triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]
            ) {
                continue;
            }


            if (triplet[0] === target[0]) foundFirst = true;
            if (triplet[1] === target[1]) foundSecond = true;
            if (triplet[2] === target[2]) foundThird = true;
        }



        return foundFirst && foundSecond && foundThird;
    }
}
