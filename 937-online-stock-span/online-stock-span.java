class StockSpanner {

    List<Integer> list;
    Stack<Integer> span;

    public StockSpanner() {
        list = new ArrayList<>();
        span = new Stack<>();
    }
    
    public int next(int price) {
        list.add(price);

        while((!span.isEmpty()) && list.get(span.peek()) <= price) span.pop();

        int value = 0;

        if (span.isEmpty()) value = list.size();
        else value = list.size() - span.peek() - 1;

        span.push(list.size() - 1);
        return value;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */