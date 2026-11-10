class Twitter {

    int count;
    Map<Integer, List<int[]>> postMap;
    Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.postMap = new HashMap<>();
        this.followMap = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        this.postMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId, ++this.count});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followList = this.followMap.getOrDefault(userId, new HashSet<>());
        followList.add(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int fId:followList){
            for(int[] post:this.postMap.getOrDefault(fId, Collections.emptyList())){
                pq.add(post);
                if(pq.size()>10) pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        this.followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.followMap.get(followerId).remove(followeeId);
    }
}
