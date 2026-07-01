class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        Set<String> visit = new HashSet();
        Queue<String> q = new LinkedList();
        Map<String,Set<String>> adj = new HashMap();
        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                Set<String> set = adj.getOrDefault(pattern, new HashSet());
                set.add(word);
                adj.put(pattern, set);
            }
        }
        visit.add(beginWord);
        q.add(beginWord);
        int res = 1;
        while(q.size()>0){
            for(int k=q.size();k>0;k--){
                String ele = q.poll();
                if(ele.equals(endWord)) return res;
                for(int i=0;i<ele.length();i++){
                  String pattern = ele.substring(0,i) + "*" + ele.substring(i+1);
                  for(String word:adj.get(pattern)){
                    if(visit.contains(word)) continue;
                    visit.add(word);
                    q.add(word);
                  }
                }
            }
            res++;
        }
        return 0;
    }
}
