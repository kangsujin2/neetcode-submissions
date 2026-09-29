class Twitter {
    Map<Integer, Set<Integer>> fm;
    List<int[]> tl;

    public Twitter() {
        fm = new HashMap<>();
        tl = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tl.add(new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> followees = fm.getOrDefault(userId, new HashSet<>());
        for (int i=tl.size()-1; i >= 0 && res.size() < 10; i--) {
            if (tl.get(i)[0] == userId || followees.contains(tl.get(i)[0])) {
                res.add(tl.get(i)[1]);
            }
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
