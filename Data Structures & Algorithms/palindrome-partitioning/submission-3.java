class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        dfs(0, s, ls, res);
        return res;
    }

    public void dfs(int i, String s, List<String> ls, List<List<String>> res){
        if(i>=s.length()){
            res.add(new ArrayList(ls));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPali(s,i,j)) {
                ls.add(s.substring(i,j+1));
                dfs(j+1, s, ls, res);
                ls.remove(ls.size()-1);
            }
        }
    }

    private boolean isPali(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
