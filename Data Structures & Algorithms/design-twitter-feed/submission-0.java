class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap; //count, tweetid
    int count;

    public Twitter() {
        followMap = new HashMap<>();    
        tweetMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] tweet = new int[2];
        tweet[0] = count++;
        tweet[1] = tweetId;

        tweetMap
        .computeIfAbsent(userId, k -> new ArrayList<>())
        .add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0],a[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId)) continue;

            List<int[]> tweets = tweetMap.get(followeeId);
            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);
            maxHeap.offer(new int[] {tweet[0], tweet[1], followeeId, index - 1});
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] top = maxHeap.poll();
            result.add(top[1]);
            int nextIndex = top[3];
            if (nextIndex >= 0) {
                List<int[]> tweets = tweetMap.get(top[2]);
                int[] tweet = tweets.get(nextIndex);
                maxHeap.offer(new int[] {tweet[0], tweet[1], top[2], nextIndex - 1});
            }
        }
        return result;   
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);    
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)
            && followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
