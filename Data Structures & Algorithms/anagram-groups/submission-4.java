class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<Integer>> mp = new HashMap<>();
        for(String str:strs){
            Map<Character, Integer> count = new HashMap<>();
            for(char c:str.toCharArray()) count.put(c, count.getOrDefault(c, 0)+1);
            mp.computeIfAbsent(count, k -> new ArrayList()).add(str);
        }
        return new ArrayList(mp.values());
    }
}
