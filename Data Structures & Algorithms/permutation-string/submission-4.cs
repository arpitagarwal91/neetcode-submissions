public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        int[] src = new int[26];
        for(int i=0;i<s1.Length;i++){
            src[s1[i]-'a']++;
        }
        for(int i=0;i<s2.Length-s1.Length+1;i++){
            int[] dest = new int[26];
            int matches = 0;
            for(int j=i;j<i+s1.Length;j++){
                dest[s2[j]-'a']++;
            }
            for(int k=0;k<26;k++){
                if(src[k]==dest[k]) matches++;
            }
            if(matches==26) return true;
        }
        return false;
    }
}
