class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        Stack<Character> stack = new Stack();
        backtrack(0, 0, n, stack, res);
        return res;
    }

    public void backtrack(int open, int close, int n, Stack<Character> stack, List<String> res){
        if(open == close && close == n){
            StringBuilder str = new StringBuilder();
            for(int i=0;i<stack.size();i++){
                str.append(stack.get(i));
            }
            res.add(str.toString());
            return;
        }
        if(open<n){
            stack.push('(');
            backtrack(open+1, close, n, stack, res);
            stack.pop();
        }
        if(close<open){
            stack.push(')');
            backtrack(open, close+1, n, stack, res);
            stack.pop();
        }

    }
}
