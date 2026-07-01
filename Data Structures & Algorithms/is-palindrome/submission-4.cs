public class Solution {
    public bool IsPalindrome(string s) {
        int l = 0;
        int r = s.Count()-1;
        while(l<r){
            while(l<s.Count()-1 && !isCharacterOrDigit(s[l])) l++;
            while(r>-1 && !isCharacterOrDigit(s[r])) r--;
            if(isCharacterOrDigit(s[l]) && isCharacterOrDigit(s[r]) && char.ToLower(s[l])!=char.ToLower(s[r])){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public bool isCharacterOrDigit(char a){
        if(((int)a>=65 && (int)a<=90)||
        ((int)a>=97 && (int)a<=122)||
        ((int)a>=48 && (int)a<=57)){
            return true;
        }
        return false;
    }
}
