public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var visit = new HashSet<char>();
        int maxLen = 0;
        int l=0;
        int r=l;
        while(r<s.Count()){
            if(!visit.Contains(s[r])){
                visit.Add(s[r]);
                maxLen = Math.Max(maxLen, r-l+1);
                r++;
            }
            else{
                visit.Remove(s[l]);
                l++;
            }
        }
        return maxLen;
    }
}
