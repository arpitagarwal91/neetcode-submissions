class Twitter {

    Map<Integer,Set<Integer>> followMap;
    Map<Integer,List<int[]>> tweetMap;
    int count;

    public Twitter() {
        this.count = 0;
        this.followMap = new HashMap();
        this.tweetMap = new HashMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> ls = this.tweetMap.getOrDefault(userId, new ArrayList<int[]>());
        ls.add(new int[]{count++, tweetId});
        this.tweetMap.put(userId, ls);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> b[0]-a[0]);
        Set<Integer> set = this.followMap.getOrDefault(userId, new HashSet());
        set.add(userId);
        this.followMap.put(userId, set);
        for(Integer followeeId:this.followMap.get(userId)){
            if(this.tweetMap.containsKey(followeeId)){
                List<int[]> tweets = this.tweetMap.get(followeeId);
                int index = tweets.size()-1;
                int tweet[] = tweets.get(index);
                pq.add(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while(!pq.isEmpty() && res.size()<10){
            int ele[] = pq.poll();
            res.add(ele[1]);
            int index = ele[3];
            if(index>0){
                int tweet[] = this.tweetMap.get(ele[2]).get(index-1);
                pq.add(new int[]{tweet[0], tweet[1],ele[2],index-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = this.followMap.getOrDefault(followerId, new HashSet());
        set.add(followeeId);
        this.followMap.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(this.followMap.containsKey(followerId)){
            if(this.followMap.get(followerId).contains(followeeId)){
                this.followMap.get(followerId).remove(followeeId);
            }
        }
    }
}
