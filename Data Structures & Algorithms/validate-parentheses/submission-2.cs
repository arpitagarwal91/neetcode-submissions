public class Solution {
    public bool IsValid(string s) {
        var mp = new Dictionary<char, char>();
        mp[')'] = '(';
        mp['}'] = '{';
        mp[']'] = '[';
        var stack = new Stack<char>();
        for(int i=0;i<s.Count();i++){
            if(!mp.ContainsKey(s[i])) stack.Push(s[i]);
            else if(stack.Count()>0 && mp[s[i]]==stack.Peek()) stack.Pop();
            else return false;
        }
        return stack.Count()==0;
    }
}
