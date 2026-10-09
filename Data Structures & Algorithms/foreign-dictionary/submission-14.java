class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      for(String word:words) for(char c:word.toCharArray()) adj.put(c, new HashSet<>());
      for(int i=0;i<words.length-1;i++){
        String w1 = words[i];
        String w2 = words[i+1];
        int minLen = Math.min(w1.length(), w2.length());
        for(int j=0;j<minLen;j++){
            if(w1.charAt(j)!=w2.charAt(j)){
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
            else if(j==minLen-1 && w1.length()>w2.length()) return "";
        }
      }
      StringBuilder sb = new StringBuilder();
      Map<Character, Boolean> visit = new HashMap<>();
      for(char c:adj.keySet()){
        if(dfs(c, sb, adj, visit)) return "";
      }
      return sb.reverse().toString();
    }

    private boolean dfs(char c, StringBuilder sb, Map<Character, Set<Character>> adj, Map<Character, Boolean> visit){
        if(visit.containsKey(c)) return visit.get(c);
        visit.put(c, true);
        for(char nei:adj.get(c)){
            if(dfs(nei, sb, adj, visit)) return true;
        }
        visit.put(c, false);
        sb.append(c);
        return false;
    }
}
