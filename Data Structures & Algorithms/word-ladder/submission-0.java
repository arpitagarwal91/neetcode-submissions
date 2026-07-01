class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String,List<String>> nei = new HashMap();
        wordList.add(beginWord);
        for(String word:wordList){
            for(int j=0;j<word.length();j++){
                String pattern = word.substring(0,j)+"*"+word.substring(j+1);
                List<String> ls = nei.getOrDefault(pattern, new ArrayList());
                ls.add(word);
                nei.put(pattern, ls);
            }
        }
        Set<String> visit = new HashSet();
        visit.add(beginWord);
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        int res = 1;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                String word = q.poll();
                if(word.equals(endWord)) return res;
                for(int j=0;j<word.length();j++){
                    String pattern = word.substring(0,j)+"*"+word.substring(j+1);
                    for(String ne:nei.get(pattern)){
                        if(!visit.contains(ne)){
                            visit.add(ne);
                            q.add(ne);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
