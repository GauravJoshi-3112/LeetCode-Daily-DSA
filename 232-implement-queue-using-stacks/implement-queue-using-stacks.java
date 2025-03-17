class MyQueue {

    public Stack<Integer> stack1 = null;
    public Stack<Integer> stack2 = null;

    public void transferStackData(Stack s1, Stack s2) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);    
    }
    
    public int pop() {
        transferStackData(stack1, stack2);
        int elem = stack2.pop();
        transferStackData(stack2, stack1);
        return elem;
    }
    
    public int peek() {
        
        transferStackData(stack1, stack2);
        int elem = stack2.peek();
        transferStackData(stack2, stack1);
        return elem;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */