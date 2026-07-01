class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> group = new HashMap();
        for(int i=0;i<strs.length;i++){
            Map<Character, Integer> count = new HashMap();
            for(int j=0;j<strs[i].length();j++){
                count.put(strs[i].charAt(j), count.getOrDefault(strs[i].charAt(j), 0)+1);
            }
            if(group.containsKey(count)){
                List<String> anagrams = group.get(count);
                anagrams.add(strs[i]);
                group.put(count, anagrams);
            }
            else{
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(strs[i]);
                group.put(count, anagrams);
            }
            //List<String> anagrams = group.getorDefault(count, new ArrayList<String>());
        }
        for(Map count:group.keySet()){
            result.add(group.get(count));
        }
        return result;
    }
}
