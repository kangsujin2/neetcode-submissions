class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> fm;
    private Map<Integer, List<int[]>> tm;

    public Twitter() {
        time = 0;
        fm = new HashMap<>();
        tm = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        tm.putIfAbsent(userId, new ArrayList<>());
        tm.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(tm.getOrDefault(userId, new ArrayList<>()));
        for (int followeeId : fm.getOrDefault(userId, new HashSet<>())) {
            feed.addAll(tm.getOrDefault(followeeId, new ArrayList<>()));
        }

        feed.sort((a,b) -> b[0] - a[0]);

        
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<Math.min(10, feed.size()); i++) {
            res.add(feed.get(i)[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            fm.putIfAbsent(followerId, new HashSet<>());
            fm.get(followerId).add(followeeId);
        }
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        fm.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
