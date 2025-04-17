class ListNode {
    int key;
    int data;
    ListNode prev;
    ListNode next;
    ListNode(int key, int data) {
        this.key = key;
        this.data = data;
    }
    ListNode(int key , int data, ListNode prev, ListNode next) {
        this.key = key;
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    public int capacity = 0;
    public ListNode head = new ListNode(-1,-1,null, new ListNode(-1,-1,null,null));
    public ListNode tail = head.next;
    public HashMap<Integer,ListNode> map = new HashMap<>();
    
    public void deleteNode(ListNode node) {
        ListNode prevNode = node.prev;
        prevNode.next = node.next;
        ListNode nextNode = node.next;
        nextNode.prev = prevNode;
    }

    public void insertTail (ListNode node) {
        ListNode prev = tail.prev;
        node.prev = prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            deleteNode(node);
            insertTail(node);
            return node.data;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.data = value;
            deleteNode(node);
            insertTail(node);
        } else if (capacity == map.size()) {
            ListNode LRU = head.next;
            map.remove(LRU.key);
            deleteNode(head.next);
            ListNode node = new ListNode(key ,value);
            insertTail(node);
            map.put(key,node);
        } else {
            ListNode node = new ListNode(key, value);
            insertTail(node);
            map.put(key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */