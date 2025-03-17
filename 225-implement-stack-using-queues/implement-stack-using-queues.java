class MyStack {

    // Implementing Stack using Single Queue

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        // For Pushing Every Element just Simply Perform a Loop for N-1
        queue.offer(x);
        int curr = queue.size();
        while (curr > 1) {
            queue.offer(queue.poll());
            curr--;
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.element();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */