class Solution {
    /**
     * @param {string} S
     * @return {number[]}
     */
    partitionLabels(S: string): number[] {
        const last = new Map<string, number>();

        for (let i=0; i<S.length; i++) {
            last.set(S[i], i);
        }

        const result: number[] = [];
        let start = 0;
        let end = 0;

        for (let i=0; i<S.length; i++) {
            end = Math.max(end, last.get(S[i]));

            if (i===end) {
                result.push(end -start + 1);
                start = i+1;
            }


        }

        return result;
    }
}
