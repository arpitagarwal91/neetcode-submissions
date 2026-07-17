class Twitter {

    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<int[]>> tweetMap;
    int count = 0;

    public Twitter() {
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> ls = tweetMap.getOrDefault(userId, new ArrayList<>());
        ls.add(new int[]{this.count, tweetId});
        tweetMap.put(userId, ls);
        this.count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        this.followerMap.computeIfAbsent(userId, k->new HashSet<>()).add(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        for(int followeeId:this.followerMap.getOrDefault(userId, new HashSet<>())){
            List<int[]> ele = this.tweetMap.getOrDefault(followeeId, new ArrayList<>());
            int idx = ele.size()-1;
            if(idx>=0){
                pq.add(new int[]{ele.get(idx)[0], ele.get(idx)[1], followeeId, idx});
            }
        }
        while(pq.size()>0 && res.size()<10){
            int[] ele = pq.poll();
            res.add(ele[1]);
            if(ele[3]>0){
                int[] tweet = this.tweetMap.get(ele[2]).get(ele[3]-1);
                pq.add(new int[]{tweet[0], tweet[1], ele[2], ele[3]-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        this.followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = this.followerMap.getOrDefault(followerId, new HashSet<>());
        if(set.contains(followeeId)){
            set.remove(followeeId);
            this.followerMap.put(followerId, set);
        }
    }
}
