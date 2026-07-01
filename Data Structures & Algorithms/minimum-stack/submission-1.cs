public class MinStack {

    Stack<int> stack;
    Stack<int> minStack;

    public MinStack() {
        this.stack = new Stack<int>();
        this.minStack = new Stack<int>();
    }
    
    public void Push(int val) {
        int min = Math.Min(stack.Count>0 ? minStack.Peek() : val, val);
        minStack.Push(min);
        stack.Push(val);
    }
    
    public void Pop() {
        stack.Pop();
        minStack.Pop();
    }
    
    public int Top() {
        return stack.Peek();
    }
    
    public int GetMin() {
        return minStack.Peek();
    }
}
