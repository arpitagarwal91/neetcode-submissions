public class Solution {
    public bool IsAnagram(string s, string t) {
        if(s.Length!=t.Length) return false;
        char []src = new char[26];
        char []dest = new char[26];
        for(int i=0;i<s.Length;i++){
            src[s[i]-'a']++;
            dest[t[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            if(src[i]!=dest[i]) return false;
        }
        return true;
    }
}
