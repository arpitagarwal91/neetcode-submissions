class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> valid = new HashSet<>(wordList);
        if(!valid.contains(endWord)) return 0;
        if(beginWord.equals(endWord)) return 0;
        Set<String> visit = new HashSet<>();
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        visit.add(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().getKey();
            int level = q.poll().getValue();
            if(word.equals(endWord)) return level;
            for(int i=0;i<word.length();i++){
                char arr[] = word.toCharArray();
                for(char c='a';c<='z';c++){
                    arr[i] = c;
                    String updatedWord = new String(arr);
                    if(valid.contains(updatedWord) && !visit.contains(updatedWord)){
                        visit.add(updatedWord);
                        q.add(new Pair(updatedWord, level+1));
                    }
                }
            }
        }
        return 0;
    }
}
