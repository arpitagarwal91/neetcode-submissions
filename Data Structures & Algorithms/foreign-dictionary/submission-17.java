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
            if(j==minLen-1 && w1.length()>w2.length()) return "";
        }
      }
      StringBuilder sb = new StringBuilder();
      Set<Character> visit = new HashSet<>();
      Set<Character> cycle = new HashSet<>();
      for(char c:adj.keySet()){
        if(!dfs(c, adj, sb, visit, cycle)) return "";
      }
      return sb.reverse().toString();
    }

    private boolean dfs(char c, Map<Character, Set<Character>> adj, StringBuilder sb, Set<Character> visit, Set<Character> cycle){
        if(cycle.contains(c)) return false;
        if(visit.contains(c)) return true;
        cycle.add(c);
        for(char nei:adj.get(c)){
            if(!dfs(nei, adj, sb, visit, cycle)) return false;
        }
        cycle.remove(c);
        visit.add(c);
        sb.append(c);
        return true;
    }
}
