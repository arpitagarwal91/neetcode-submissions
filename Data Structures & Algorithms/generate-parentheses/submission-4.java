class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0,0,n,new ArrayList<Character>(),res);
        return res;
    }

    public void backtrack(int open, int close, int n, List<Character> ls, List<String> res){
        if(open==close && close==n){
            StringBuilder sb = new StringBuilder();
            for(char c:ls) sb.append(c);
            res.add(sb.toString());
            return;
        }
        if(open<n){
            ls.add('(');
            backtrack(open+1, close, n, ls, res);
            ls.remove(ls.size()-1);
        }
        if(close<open){
            ls.add(')');
            backtrack(open, close+1, n, ls, res);
            ls.remove(ls.size()-1);
        }
    }
}
