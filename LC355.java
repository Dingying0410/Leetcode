class Twitter {

    //Use a hashmap to map the userId to the user
    //postTweet: append the tweet to the user
    //getNewsFeed: find all the followers's tweet, push them into a priority queue, which is sorted by the timestamp
    //follow: add the the follow set

    Map<Integer, User> map;
    static int timeStamp;

    class User {
        int userId;
        Tweet tweet;
        Set<Integer> follow;

        public User (int userId) {
            this.userId = userId;
            follow = new HashSet<>();
            follow.add(userId);
        }
    }

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        public Tweet (int tweetId) {
            this.tweetId = tweetId;
            this.time = timeStamp++;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
        timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        User user = map.get(userId);
        tweet.next = user.tweet;
        user.tweet = tweet;
        map.put(userId, user);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        if (!map.containsKey(userId))
            return res;
        for (int followee : map.get(userId).follow) {
            if (!map.containsKey(followee)) {
                continue;
            }
            Tweet cur = map.get(followee).tweet;
            while (cur != null) {
                pq.offer(cur);
                cur = cur.next;
            }
        }
        while (res.size() < 10 && !pq.isEmpty()) {
            res.add(pq.poll().tweetId);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User(followerId));
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }
        map.get(followerId).follow.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (!map.containsKey(followerId))
            return;
        map.get(followerId).follow.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
