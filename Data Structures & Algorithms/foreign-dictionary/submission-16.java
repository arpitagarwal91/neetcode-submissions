class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      for(String word:words) for(char c:word.toCharArray()) adj.put(c, new HashSet<>());
      for(int i=0;i<words.length-1;i++){
        String w1 = words[i];
        String w2 = words[i+1];
        int minLen = Math.min(w1.length(), w2.length());
        for(int k=0;k<minLen;k++){
            if(w1.charAt(k)!=w2.charAt(k)){
                Set<Character> set = adj.get(w1.charAt(k));
                set.add(w2.charAt(k));
                adj.put(w1.charAt(k), set);
                break;
            }
            else if(k==minLen-1 && w1.length()>w2.length()) return "";
        }
      }
      Map<Character, Boolean> visit = new HashMap<>();
      StringBuilder sb = new StringBuilder();
      for(char c:adj.keySet()){
        if(dfs(c, adj, sb, visit)) return "";
      }
      return sb.reverse().toString();
    }

    private boolean dfs(char c, Map<Character, Set<Character>> adj, StringBuilder sb, Map<Character, Boolean> visit){
        if(visit.containsKey(c)) return visit.get(c);
        visit.put(c, true);
        for(char nei:adj.get(c)){
            if(dfs(nei, adj, sb, visit)) return true;
        }
        visit.put(c, false);
        sb.append(c);
        return false;
    }
}
