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
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        // Do through Recursion
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = merge2Lists(l1.next,l2);
            return l1;
        } else {
            l2.next = merge2Lists(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        for (int i=0; i<lists.length; i++) {
            head.next = merge2Lists(head.next,lists[i]);
        }

        return head.next;
    }
}