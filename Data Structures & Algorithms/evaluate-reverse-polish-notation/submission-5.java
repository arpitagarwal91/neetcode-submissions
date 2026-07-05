class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            switch(token){
                case "+":
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1+op2);
                    break;
                case "-":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2-op1);
                    break;
                case "*":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2*op1);
                    break;
                case "/":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2/op1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
