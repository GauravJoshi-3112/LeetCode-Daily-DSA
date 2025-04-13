/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Finding Middle of the linked list
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Linked List Reverse
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = temp;
            temp = curr;
            curr = nxt;
        }
        return temp;
    }

    public void reorderList(ListNode head) {
        // Splitting Linked List into two part
        ListNode mid = getMiddle(head);
        ListNode head1 = head;
        ListNode head2 = reverse(mid);
        head = new ListNode(-1);
        ListNode curr = head;

        // Combine
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                curr.next = head1;
                break;
            }
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
            curr.next = head2;
            head2 = head2.next;
            curr = curr.next;
        }

        head = head.next;
    }
}