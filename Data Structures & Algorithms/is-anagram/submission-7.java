class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> src = new HashMap<>();
        for(char c:s.toCharArray()) src.put(c, src.getOrDefault(c, 0)+1);
        Map<Character, Integer> dest = new HashMap<>();
        for(char c:t.toCharArray()) dest.put(c, dest.getOrDefault(c, 0)+1);
        return src.equals(dest);
    }
}
