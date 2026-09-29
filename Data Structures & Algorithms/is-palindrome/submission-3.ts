class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s: string): boolean {
        let left = 0;
        let right = s.length-1;

        function isAlphanumeric(char: string): boolean {
            const c = char.toLowerCase();

            return (c >= "a" && c <= "z") || (c >= "0" && c<= "9");
        }

        while (left<right) {
            if (!isAlphanumeric(s[left])) {
                left++;
                continue;
            }

            if (!isAlphanumeric(s[right])) {
                right--;
                continue;
            }

            if (s[left].toLowerCase() !== s[right].toLowerCase()) return false;

            left++;
            right--;
        }

        return true;
    }
}
