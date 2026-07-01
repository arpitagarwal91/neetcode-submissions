class Solution {

    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> visit;
    List<Character> res;

    public String foreignDictionary(String[] words) {
      adj = new HashMap();
      visit = new HashMap();
      res = new ArrayList();
      for (String word : words) {
        for (char c : word.toCharArray()) {
          adj.putIfAbsent(c, new HashSet<>());
        }
      }
      for(int i=0;i<words.length-1;i++){
        String w1 = words[i], w2 = words[i+1];
        int minLen = Math.min(w1.length(),w2.length());
        for(int j=0;j<minLen;j++){
          if(w1.charAt(j)==w2.charAt(j) && w1.length()>w2.length()) return "";
          if(w1.charAt(j)!=w2.charAt(j)){
            Set<Character> set = adj.getOrDefault(w1.charAt(j), new HashSet());
            set.add(w2.charAt(j));
            adj.put(w1.charAt(j), set);
            break;
          }
        }
      }
      for(Character c:adj.keySet()){
        if(dfs(c)) return "";
      }
      Collections.reverse(res);
      StringBuilder sb = new StringBuilder();
      for(Character c:res) sb.append(c);
      return sb.toString();
    }

    public boolean dfs(Character c){
      if(visit.containsKey(c)) return visit.get(c);
      visit.put(c, true);
      for(char nei : adj.getOrDefault(c, new HashSet<Character>())){
        if(dfs(nei)) return true;
      }
      res.add(c);
      visit.put(c, false);
      return false;
    }
}
