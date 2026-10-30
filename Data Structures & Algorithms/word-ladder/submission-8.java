class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> valid = new HashSet<>(wordList);
        if(!valid.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> visit = new HashSet<>();
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        visit.add(beginWord);

        while(!q.isEmpty()){
            Pair<String, Integer> ele = q.poll();
            String word = ele.getKey();
            if(word.equals(endWord)) return ele.getValue();
            for(int i=0;i<word.length();i++){
                char arr[] = word.toCharArray();
                for(char c='a';c<='z';c++){
                    arr[i] = c;
                    String newWord = new String(arr);
                    if(valid.contains(newWord) && !visit.contains(newWord)){
                        q.add(new Pair(newWord, ele.getValue()+1));
                        visit.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
