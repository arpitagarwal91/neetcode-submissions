class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str:tokens){
            switch(str){
                case "+":
                    int op1 = st.pop();
                    int op2 = st.pop();
                    st.push(op1+op2);
                    break;
                case "-":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push(op2-op1);
                    break;
                case "*":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push(op1*op2);
                    break;
                case "/":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push(op2/op1);
                    break;
                default:
                    st.push(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
}
