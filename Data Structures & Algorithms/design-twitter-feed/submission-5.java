class Twitter {
    private Map<Integer, User> data;
    private int globalTimer;

    public Twitter() {
        data = new HashMap<>();
        globalTimer = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = data.get(userId);
        if (user == null) {
            user = new User(userId);
            data.put(userId, user);
        }
        user.post(tweetId, globalTimer++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!data.containsKey(userId)) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        User user = data.get(userId);

        for (int followee : user.followers) {
            User fUser = data.get(followee);
            if (fUser != null && fUser.head != null) {
                maxHeap.add(fUser.head);
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            Tweet t = maxHeap.poll();
            res.add(t.id);

            if (t.next != null) {
                maxHeap.add(t.next);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = data.computeIfAbsent(followerId, User::new);
        data.computeIfAbsent(followeeId, User::new);
        follower.follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (data.containsKey(followerId) && followerId != followeeId) {
            data.get(followerId).unfollow(followeeId);
        }
        
    }

    class User {
        int id;
        Set<Integer> followers;
        Tweet head;

        public User(int userId) {
            id = userId;
            followers = new HashSet<>();
            follow(userId);
            head = null;
        }

        public void follow(int id) {
            followers.add(id);
        }

        public void unfollow(int id) {
            followers.remove(id);
        }

        public void post(int tweetId, int time) {
            Tweet tweet = new Tweet(tweetId, time);
            tweet.next = head;
            head = tweet;
        }
    }

    class Tweet implements Comparable<Tweet> {
        int id;
        int time;
        Tweet next;

        public Tweet(int tweetId, int time) {
            id = tweetId;
            this.time = time;
            next = null;
        }

        @Override
        public int compareTo(Tweet that) {
            return Integer.compare(this.time, that.time);
        }
    }
}