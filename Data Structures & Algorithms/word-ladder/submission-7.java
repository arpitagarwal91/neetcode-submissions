class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        Set<String> valid = new HashSet<>(wordList);
        if(!valid.contains(endWord)) return 0;
        valid.add(beginWord);

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        q.add(new Pair(beginWord, 1));
        visit.add(beginWord);

        while(!q.isEmpty()){
            Pair<String, Integer> ele = q.poll();
            String word = ele.getKey();
            int dist = ele.getValue();
            if(word.equals(endWord)) return dist;
            for(int j=0;j<word.length();j++){
                char arr[] = word.toCharArray();
                for(char c='a';c<='z';c++){
                    arr[j] = c;
                    String newWord = new String(arr);
                    if(!valid.contains(newWord) || visit.contains(newWord)) continue;
                    q.add(new Pair(newWord, dist+1));
                    visit.add(newWord);
                }
            }
        }
        return 0;
    }
}
