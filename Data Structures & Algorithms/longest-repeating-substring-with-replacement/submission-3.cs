public class Solution {
    public int CharacterReplacement(string s, int k) {
        int []count = new int[26];
        int i=0, j=0;
        int max = 0;
        int res = 0;
        while(j<s.Count()){
            count[s[j] - 'A']++;
            max = Math.Max(max, count[s[j] - 'A']);
            if(j-i+1 - max > k){
                count[s[i] - 'A']--;
                i++;
            }
            res = Math.Max(res, j-i+1);
            j++;
        }
        return res;
    }
}
