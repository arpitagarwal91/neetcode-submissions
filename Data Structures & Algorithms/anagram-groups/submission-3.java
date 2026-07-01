class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> mp = new HashMap();
        for(String str:strs){
            Map<Character,Integer> cmap = new HashMap();
            for(int i=0;i<str.length();i++){
                cmap.put(str.charAt(i), cmap.getOrDefault(str.charAt(i),0)+1);
            }
            List<String> ls = mp.getOrDefault(cmap, new ArrayList<String>());
            ls.add(str);
            mp.put(cmap, ls);
        }
        return new ArrayList(mp.values());
    }
}
