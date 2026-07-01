public class Solution {
    public string MinWindow(string s, string t) {
        if(t=="") return "";
        Dictionary<char, int> src = new Dictionary<char, int>();
        Dictionary<char, int> dest = new Dictionary<char, int>();
        for(int i=0;i<t.Length;i++){
            if(src.ContainsKey(t[i])){
                src[t[i]]++;
            }
            else{
                src[t[i]] = 1;
            }
        }
        int have = 0;
        int need = src.Count;
        int []res = {-1, -1};
        int resLen = int.MaxValue;
        int l = 0;
        for(int r=0;r<s.Length;r++){
            if(src.ContainsKey(s[r]) && dest.ContainsKey(s[r])){
                dest[s[r]]++;
                if(src[s[r]]==dest[s[r]]) have++;
            }
            else if(src.ContainsKey(s[r])){
                dest[s[r]] = 1;
                if(src[s[r]]==dest[s[r]]) have++;
            }
            while(have==need){
                if(r-l+1<resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = r-l+1;
                }
                if(src.ContainsKey(s[l])){
                    dest[s[l]]--;
                    if(src[s[l]]>dest[s[l]]) have--;
                }
                l++;
            }
        }
        return resLen==int.MaxValue ? "" : s.Substring(res[0], resLen);
    }
}
