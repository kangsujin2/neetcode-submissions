class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> s = new Stack<>();

        for (int i=0; i<temperatures.length; i++) {
            int temp = temperatures[i];

            while (!s.isEmpty() && temp > s.peek()[0]) {
                int[] pair = s.pop();
                res[pair[1]] = i - pair[1];
            }

            s.push(new int[]{temp, i});
        }

        return res;
    }
}
