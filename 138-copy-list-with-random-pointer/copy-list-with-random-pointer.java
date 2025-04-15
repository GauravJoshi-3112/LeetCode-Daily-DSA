/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void duplicateLL(Node head) {
        Node curr = head;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = nxt;
            curr = curr.next.next;
        }
    }

    public void assigningRandom(Node head) {
        Node curr = head;
        while (curr != null) {
            Node random = curr.random;
            curr.next.random = random != null ? random.next : random;
            curr = curr.next.next;
        }
    }

    public Node seperatingList(Node head) {
        if (head == null) return head;
        Node newHead = new Node(-1);
        newHead.next = head;
        Node curr = newHead;
        while (curr != null && curr.next != null) {
            Node nxt = curr.next.next;
            Node point = curr.next;
            point.next = nxt.next;
            curr.next = nxt;
            curr = curr.next;
        }
        return newHead.next;
    }

    public Node copyRandomList(Node head) {
        duplicateLL(head);
        assigningRandom(head);
        Node nHead = seperatingList(head);
        return nHead;
    }
}