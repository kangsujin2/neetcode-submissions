class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] index = new int[128];
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (index[currentChar] > 0) {
                start = Math.max(start, index[currentChar]);
            }

            index[currentChar] = end + 1;

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
