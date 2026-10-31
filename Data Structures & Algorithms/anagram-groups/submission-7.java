class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> adj = new HashMap<>();
        for(String str:strs){
            Map<Character, Integer> countMap = new HashMap<>();
            for(char c:str.toCharArray()){
                countMap.put(c, countMap.getOrDefault(c, 0)+1);
            }
            adj.computeIfAbsent(countMap, k->new ArrayList<>()).add(str);
        }
        return new ArrayList(adj.values());
    }
}
