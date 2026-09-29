class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int[][] arr = new int[count.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr[i][0] = entry.getValue();
            arr[i][1] = entry.getKey();
            i++;
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));

        int[] res = new int[k];
        for (int j=0; j<k; j++) {
            res[j] = arr[j][1];
        }

        return res;

    }
}
