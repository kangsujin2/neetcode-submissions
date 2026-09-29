class Twitter {
    Map<Integer, Set<Integer>> fm;
    Map<Integer, List<int[]>> tm;
    int time;

    public Twitter() {
        fm = new HashMap<>();
        tm = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tm.computeIfAbsent(userId, key -> new ArrayList<>()).add(new int[]{tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        Set<Integer> followees = new HashSet<>(fm.getOrDefault(userId, new HashSet<>()));
        followees.add(userId);

        for (int followee : followees) {
            if (tm.containsKey(followee)) {
                List<int[]> tweets = tm.get(followee);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followee, index});
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] latest = minHeap.poll();
            res.add(latest[0]);
            int index = latest[3];
            if (index > 0) {
                int[] tweet = tm.get(latest[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], latest[2], index - 1});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        fm.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (fm.containsKey(followerId)) {
            fm.get(followerId).remove(followeeId);
        }
    }
}