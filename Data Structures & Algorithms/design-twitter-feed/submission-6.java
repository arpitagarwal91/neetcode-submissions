class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> postMap;
    int count = 0;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.postMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        this.postMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{this.count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = this.followMap.getOrDefault(userId, new HashSet<>());
        follows.add(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int uId:follows){
            List<int[]> posts = this.postMap.getOrDefault(uId, Collections.emptyList());
            for(int post[]:posts){
                pq.add(post);
                if(pq.size()>10) pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll()[1]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        this.followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!this.followMap.containsKey(followerId)) return;
        if(this.followMap.get(followerId).contains(followeeId)){
            this.followMap.get(followerId).remove(followeeId);
        }
    }
}
