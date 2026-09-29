class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) start = Math.max(start, map.get(s.charAt(i)));
            map.put(s.charAt(i), i+1);
            res = Math.max(res, i - start + 1);
        }

        return res;
    }
}
