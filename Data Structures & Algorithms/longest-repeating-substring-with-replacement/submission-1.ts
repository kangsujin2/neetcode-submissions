class Solution {
    /**
     * @param {string} s
     * @param {number} k
     * @return {number}
     */
    characterReplacement(s: string, k: number): number {
        const counts = new Map<string, number>();
        let start = 0;
        let maxCount = 0;
        let result = 0;

        for (let end = 0; end < s.length; end++) {
            let char = s[end];
            counts.set(char, (counts.get(char) ?? 0) + 1);

            maxCount = Math.max(maxCount, counts.get(char));

            while (end - start + 1 - maxCount > k) {
                counts.set(s[start], counts.get(s[start])! - 1);
                start++;
            }

            result = Math.max(result, end - start + 1);
        }

        return result;
    }
}
