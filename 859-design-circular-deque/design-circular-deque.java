class MyCircularDeque {

    int [] deque;
    int front;
    int rear;
    int size = 0;
    int k = 0;

    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        rear = k - 1;
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front -1 + k) % k;
        deque[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % k;
        deque[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % k;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + k)% k;
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.deque.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */