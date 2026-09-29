class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                int len = left + right + 1;

                map.put(num, len);
                map.put(num - left, len);
                map.put(num + right, len);
                res = Math.max(res, map.get(num));

            }
        }

        return res;
    }
}
