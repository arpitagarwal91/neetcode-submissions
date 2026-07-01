class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> stack = new Stack<Character>();
        List<String> res = new ArrayList();
        backtrack(0,0,n,stack,res);
        return res;
    }

    public void backtrack(int open, int close, int n, Stack<Character> str, List<String> res){
        if(open == close && close == n){
            String op = "";
            for(Character c:str){
                op+=c;
            }
            res.add(op);
            return;
        }
        if(open<n){
            str.push('(');
            backtrack(open+1, close, n, str, res);
            str.pop();
        }
        if(close<open){
            str.push(')');
            backtrack(open, close+1, n, str, res);
            str.pop();
        }
    }
}
