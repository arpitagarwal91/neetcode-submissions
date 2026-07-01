public class Solution {
    public List<List<string>> Partition(string s) {
        List<List<string>> res = new();
        List<string> ls = new();
        dfs(0,s,ls,res);
        return res;
    }

    public void dfs(int i, string s, List<string> ls, List<List<string>> res){
        if(i>=s.Count()){
            res.Add(new List<string>(ls));
            return;
        }
        for(int k=i;k<s.Count();k++){
            if(IsPali(s,i,k)){
                ls.Add(s.Substring(i,k+1-i));
                dfs(k+1,s,ls,res);
                ls.RemoveAt(ls.Count()-1);
            }
        }
    }

    public bool IsPali(string s, int l, int r){
        while(l<r){
            if(s[l]!=s[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
