class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      for(String word:words){
        for(char c:word.toCharArray()) adj.put(c, new HashSet<>());
      }
      for(int i=0;i<words.length-1;i++){
        int j = i+1;
        int len = Math.min(words[i].length(), words[j].length());
        if(words[i].length()>len && words[i].substring(0, len).equals(words[j])) return "";
        for(int k=0;k<len;k++){
          if(words[i].charAt(k)!=words[j].charAt(k)){
            adj.computeIfAbsent(words[i].charAt(k), p->new HashSet<>()).add(words[j].charAt(k));
            break;
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      Map<Character, Boolean> visit = new HashMap<>();
      for(Character c:adj.keySet()) if(dfs(c, adj, sb, visit)) return "";
      return sb.reverse().toString();
    }

    private boolean dfs(Character c, Map<Character, Set<Character>> adj, StringBuilder sb, Map<Character, Boolean> visit){
      if(visit.containsKey(c)) return visit.get(c);
      visit.put(c, true);
      for(Character nei:adj.getOrDefault(c, new HashSet<>())){
        if(dfs(nei, adj, sb, visit)) return true;
      }
      visit.put(c, false);
      sb.append(c);
      return false;
    }
}
