class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        List<String> part = new ArrayList();
        dfs(0,s,part,res);
        return res;
    }

    public void dfs(int i, String s, List<String> part, List<List<String>> res){
        if(i>=s.length()){
            res.add(new ArrayList(part));
            return;
        }
        for(int k=i;k<s.length();k++){
            if(isPali(s,i,k)){
                part.add(s.substring(i,k+1));
                dfs(k+1,s,part,res);
                part.remove(part.size()-1);
            }
        }
    }

    public boolean isPali(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
