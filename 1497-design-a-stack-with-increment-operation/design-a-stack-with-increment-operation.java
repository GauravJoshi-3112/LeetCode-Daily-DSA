class CustomStack {

    int [] stack;
    int [] inc;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
        top = 0;
    }
    
    public void push(int x) {
        if (top >= stack.length) return;
        stack[top++] = x;
    }
    
    public int pop() {
        if (top <= 0) return -1;
        top--;
        int poppedElem = stack[top] + inc[top];
        if (top > 0) inc[top-1] += inc[top];
        inc[top] = 0;
        return poppedElem; 
    }
    
    public void increment(int k, int val) {
        if (k <= 0 || top == 0) return;
        int index = Math.min(k,top)-1;
        inc[index] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */