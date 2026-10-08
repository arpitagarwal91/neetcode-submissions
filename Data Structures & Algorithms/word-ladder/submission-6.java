class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> valid = new HashSet<>();
        for(String word:wordList) valid.add(word);
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> visit = new HashSet<>();
        int res = 0;
        while(!q.isEmpty()){
            Pair<String, Integer> ele = q.poll();
            String word = ele.getKey();
            if(word.equals(endWord)) return ele.getValue();
            for(int j=0;j<word.length();j++){
                for(char c='a';c<='z';c++){
                    char arr[] = word.toCharArray();
                    char temp = arr[j];
                    arr[j] = c;
                    String newStr = new String(arr);
                    if(valid.contains(newStr) && !visit.contains(newStr)){
                        q.add(new Pair(newStr, ele.getValue()+1));
                        visit.add(newStr);
                        valid.remove(newStr);
                    }
                }
            }
        }
        return 0;
    }
}
