class ListNode {
    int data;
    ListNode next;
    ListNode(int data) {
        this.data = data;
    }
    ListNode(int data, ListNode next) {
        this.next = next;
    }
}

class MyCircularQueue {

    ListNode head = new ListNode(-1);
    ListNode tail = head;
    int size = 0;
    int capacity = 0;

    public MyCircularQueue(int k) {
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if (size >= capacity) return false;
        else {
            ListNode elem = new ListNode(value);
            tail.next = elem;
            tail = tail.next;
            tail.next = head.next;
            size++;
            return true;
        } 
    }
    
    public boolean deQueue() {
        if (size <= 0) return false; 
        else {
            if (head.next == tail) {
                head.next = null;
                tail = head;
            } else {
                head.next = head.next.next;
                tail.next = head.next;
            }
            size--;
            return true;
        }
    }
    
    public int Front() {
        if (size == 0) return head.data;
        else return head.next.data;
    }
    
    public int Rear() {
        if (size == 0) return head.data;
        else return tail.data;
    }
    
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }
    
    public boolean isFull() {
        if (size < capacity) return false;
        else return true;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */