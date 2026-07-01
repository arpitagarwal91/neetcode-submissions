class Solution {
    public boolean isAnagram(String s, String t) {
        char src[] = s.toCharArray();
        char dest[] = t.toCharArray();
        Arrays.sort(src);
        Arrays.sort(dest);
        String s1 = new String(src);
        String s2 = new String(dest);
        return s1.equals(s2);
    }
}
