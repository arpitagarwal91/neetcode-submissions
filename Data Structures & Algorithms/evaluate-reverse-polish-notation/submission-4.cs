public class Solution {
    public int EvalRPN(string[] tokens) {
        var stack = new Stack<string>();
        foreach(string token in  tokens){
            if(token.Equals("+")||token.Equals("-")||token.Equals("*")||token.Equals("/")){
                var op1 = Int32.Parse(stack.Pop());
                var op2 = Int32.Parse(stack.Pop());
                var res = "";
                if(token.Equals("+")) res = (op1+op2).ToString();
                else if(token.Equals("-")) res = (op2-op1).ToString();
                else if(token.Equals("*")) res = (op1*op2).ToString();
                else if(token.Equals("/")) res = (op2/op1).ToString();
                stack.Push(res.ToString());
            }
            else{
                stack.Push(token);
            }
        }
        return Int32.Parse(stack.Peek());
    }
}
