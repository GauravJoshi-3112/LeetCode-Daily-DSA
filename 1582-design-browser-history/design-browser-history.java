class BrowserHistory {

    Stack<String> backwardStack;
    Stack<String> forwardStack;
    String homepage;
 
    public BrowserHistory(String homepage) {
        backwardStack = new Stack<>();
        backwardStack.push(homepage);
        this.homepage = homepage;
        forwardStack = new Stack<>();
    }
    
    public void visit(String url) {
        backwardStack.push(url);
        forwardStack.clear();
    }
    
    public String back(int steps) {
        while (steps > 0 && backwardStack.size() > 1) {
            forwardStack.push(backwardStack.pop());
            steps--;
        }
        return backwardStack.peek();
    }
    
    public String forward(int steps) {
        while (steps > 0 && forwardStack.size() > 0) {
            backwardStack.push(forwardStack.pop());
            steps--;
        }
        return backwardStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */