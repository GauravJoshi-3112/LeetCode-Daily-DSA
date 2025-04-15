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
    public ListNode reverseLL(ListNode start, ListNode end) {
        // // return head
        // ListNode node = new ListNode(-1);
        // node.next = start;
        ListNode prev = null;
        while (start != null && prev != end) {
            ListNode nxt = start.next;
            start.next = prev;
            prev = start;
            start = nxt;
        }
        return prev;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tHead = new ListNode(-1, head);
        ListNode curr = head, prev = tHead, next = head;
        int count = 0;

        while (curr != null) {
            if (count == k-1) {
                ListNode temp = prev.next;
                ListNode nxt = curr.next;
                prev.next = reverseLL(prev.next, curr);
                temp.next = nxt;
                curr = nxt;
                prev = temp;
                count = 0;
            } else {
                curr = curr.next;
                count++;
            }
        }

        return tHead.next;
    }
}