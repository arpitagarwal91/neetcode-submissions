class MinStack {

    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        this.st = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        this.st.push(val);
        this.minStack.push(Math.min(!this.minStack.isEmpty() ? this.minStack.peek() : val, val));
    }
    
    public void pop() {
        this.st.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.st.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
