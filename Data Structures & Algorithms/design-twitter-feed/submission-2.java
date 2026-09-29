class Twitter {
    private int count;
    private Map<Integer, Set<Integer>> fm;
    private Map<Integer, List<int[]>> tm;


    public Twitter() {
        count = 0;
        fm = new HashMap<>();
        tm = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tm.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        fm.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : fm.get(userId)) {
            if (tm.containsKey(followeeId)) {
                List<int[]> tweets = tm.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] latest = minHeap.poll(); // {tweetId, followeeId}
            res.add(latest[1]);
            int index = latest[3];
            if (index > 0) {
                int[] tweet = tm.get(latest[2]).get(index-1);
                minHeap.offer(new int[]{tweet[0], tweet[1], latest[2], index - 1});
            }
        }

        return res;




        
    }
    
    public void follow(int followerId, int followeeId) {
        fm.putIfAbsent(followerId, new HashSet<Integer>());
        fm.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        fm.getOrDefault(followerId, new HashSet<Integer>()).remove(followeeId);

        
    }
}
