class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min_stack;

    public MinStack() {
        // Create two Stacks
        // First Normal Stack
        // Second to Maintain Minimum
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min_stack.isEmpty() || val <= min_stack.peek()) min_stack.push(val);
    }
    
    public void pop() {
        int element = stack.pop();
        if (element == min_stack.peek()) min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */