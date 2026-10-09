class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s: string): number {
        const seen = new Set<string>();
        let start = 0;
        let result = 0;

        for (let end= 0; end < s.length; end++) {
            while (seen.has(s[end])) {
                seen.delete(s[start]);
                start++;
            }
            seen.add(s[end]);
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
