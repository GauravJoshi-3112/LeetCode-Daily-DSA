class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data= data;
        this.next= next;
    }

    public Node(int data) {
        this.data = data;
    }
}

class MyCircularQueue {

    int size = 0;
    int capacity = 0;
    Node head;
    Node tail;

    public MyCircularQueue(int k) {
        // Initialization 
        this.capacity = k;
        head = new Node(-1);
        tail = head;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value);
        this.tail.next = newNode;
        this.tail = this.tail.next;
        this.size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        this.head.next = this.head.next.next;
        // We also need to check if Element getting Deleted is the Single Element
        if (this.size == 1) tail = head;
        this.size--;
        return true;
    }
    
    public int Front() {
        // Check if size == 0
        if (isEmpty()) return -1;
        else return head.next.data;
    }
    
    public int Rear() {
        // Check if size == 0
        if (isEmpty()) return -1;
        else return this.tail.data;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
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