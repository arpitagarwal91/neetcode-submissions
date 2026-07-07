class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,Set<Character>> adjList = new HashMap<>();
      for(String word:words){
        for(char c:word.toCharArray()) adjList.put(c, new HashSet<>());
      }
      for(int i=0;i<words.length-1;i++){
        String w1 = words[i], w2 = words[i+1];
        int minLen = Math.min(w1.length(), w2.length());
        if(w1.length()>w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))) return ""; //#2 Mistake used || instead of && here #2
        for(int j=0;j<minLen;j++){
            if(w1.charAt(j)!=w2.charAt(j)) {
                Set<Character> set = adjList.get(w1.charAt(j));
                set.add(w2.charAt(j));
                adjList.put(w1.charAt(j), set);
                break; //#1 Forgot this break which is important #1
            }
        }
      }
      StringBuilder res = new StringBuilder();
      Map<Character, Boolean> visit = new HashMap<>();
      for(char c:adjList.keySet()){
        if(dfs(c,adjList,visit,res)) return "";
      }
      return res.reverse().toString();
    }

    public boolean dfs(char c, Map<Character, Set<Character>> adjList, Map<Character, Boolean> visit, StringBuilder res){
        if(visit.containsKey(c)) return visit.get(c);
        visit.put(c, true);
        for(char nei:adjList.get(c)){
            if(dfs(nei, adjList, visit, res)) return true;
        }
        visit.put(c, false);
        res.append(c);
        return false;
    }
}
