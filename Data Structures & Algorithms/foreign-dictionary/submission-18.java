class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, List<Character>> adj = new HashMap<>();
      for(String word:words) for(char c:word.toCharArray()) adj.put(c, new ArrayList<>());
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
        if(!dfs(c, adj, visit, cycle, sb)) return "";
      }
      return sb.reverse().toString();
    }

    private boolean dfs(char src, Map<Character, List<Character>> adj, Set<Character> visit, Set<Character> cycle, StringBuilder sb){
        if(cycle.contains(src)) return false;
        if(visit.contains(src)) return true;
        cycle.add(src);
        for(char nei:adj.getOrDefault(src, Collections.emptyList())){
            if(!dfs(nei, adj, visit, cycle, sb)) return false;
        }
        cycle.remove(src);
        visit.add(src);
        sb.append(src);
        return true;
    }
}
