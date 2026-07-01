class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<Map<Character, Integer>, List<String>> mapToStrings = new HashMap();
       for(String str:strs){
        Map<Character, Integer> map = new HashMap();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }
        List<String> ls = mapToStrings.getOrDefault(map, new ArrayList<String>());
        ls.add(str);
        mapToStrings.put(map, ls);
       }
       return new ArrayList(mapToStrings.values());
    }
}
