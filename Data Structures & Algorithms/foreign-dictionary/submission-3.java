class Solution {

    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visit;
    private List<Character> res;

    public String foreignDictionary(String[] words) {
      adj = new HashMap();
      for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
       }
      for(int i=0;i<words.length-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        int minLen = Math.min(word1.length(), word2.length());
        if(word1.length()>word2.length() && word1.substring(0,minLen).equals(word2.substring(0,minLen))) return "";
        for(int j=0;j<minLen;j++){
            if(word1.charAt(j)!=word2.charAt(j)){
                adj.getOrDefault(word1.charAt(j), new HashSet()).add(word2.charAt(j));
                break;
            }
        }
      }
      visit = new HashMap();
      res = new ArrayList();
      for(Character c:adj.keySet()){
        if(dfs(c)) return "";
      }
      Collections.reverse(res);
      StringBuilder sb = new StringBuilder();
      for(char c:res) sb.append(c);
      return sb.toString();
    }

    public boolean dfs(char c){
        if(visit.containsKey(c)) return visit.get(c);
        visit.put(c,true);
        for(char ch:adj.get(c)){
            if(dfs(ch)) return true;
        }
        visit.put(c,false);
        res.add(c);
        return false;
    }
}