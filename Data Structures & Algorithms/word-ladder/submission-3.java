class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        Map<String, Set<String>> adj = new HashMap<>();

        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String pattern = word.substring(0,i)+"*"+word.substring(i+1, word.length());
                adj.computeIfAbsent(pattern, k -> new HashSet<>()).add(word);
            }
        }

        Set<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visit.add(beginWord);
        q.add(beginWord);
        int res = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                String word = q.poll();
                if(word.equals(endWord)) return res;
                for(int j=0;j<word.length();j++){
                    String pattern = word.substring(0,j)+"*"+word.substring(j+1, word.length());
                    for(String nei:adj.get(pattern)){
                        if(visit.contains(nei)) continue;
                        visit.add(nei);
                        q.add(nei);
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
