class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> count = new HashMap<>();
        for(String str:strs){
            Map<Character, Integer> fMap = new HashMap<>();
            for(char c:str.toCharArray()){
                fMap.put(c, fMap.getOrDefault(c, 0)+1);
            }
            count.computeIfAbsent(fMap, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(count.values());
    }
}
