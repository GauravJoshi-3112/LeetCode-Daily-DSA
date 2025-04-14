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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = new ListNode(-1);
        slow.next = head;
        head = slow;
        ListNode fast = slow;
        while (fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next != null ? slow.next.next : slow.next;

        return head.next;
    }
}