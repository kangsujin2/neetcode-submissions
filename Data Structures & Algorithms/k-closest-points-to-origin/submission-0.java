class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        for (int i=0; i<points.length; i++) {
            int dx = Math.abs(points[i][0]);
            int dy = Math.abs(points[i][1]);
            int distance = dx * dx + dy * dy;
            pq.offer(new int[]{distance, i});

            if (pq.size() > k) pq.poll();
        }

        int[][] result = new int[k][2];
        int idx = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            result[idx++] = points[top[1]];
        }

        return result;
        

    }
}
