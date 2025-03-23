class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        if (s2.isEmpty() || (val <= s2.peek())) s2.push(val);
        s1.push(val);
    }
    
    public void pop() {
        if ((!s1.isEmpty()) && (!s2.isEmpty()) && (s1.peek().equals(s2.peek()))) {
            s2.pop();
            s1.pop();
        } else if (!s1.isEmpty()) {
            s1.pop();
        }
    }
    
    public int top() {
        if (!s1.isEmpty()) {
            return s1.peek();  
        } 
        return -1;
    }
    
    public int getMin() {
        if (!s2.isEmpty()) {
            return s2.peek();  
        } 
        return -1;
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