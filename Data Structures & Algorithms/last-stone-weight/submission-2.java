class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) pq.offer(stone);

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            int weight = Math.abs(x-y);
            pq.offer(weight);
        }

        return pq.poll();

    }
}
