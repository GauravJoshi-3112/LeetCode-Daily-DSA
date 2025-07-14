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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int getDecValue(ListNode head) {
        ListNode curr = head;
        int msb = 1;
        int value = 0;

        while (curr != null) {
            value += curr.val*msb;
            msb *= 2;
            curr = curr.next;
        }

        return value;
    }
    public int getDecimalValue(ListNode head) {
        head = reverseList(head);
        return getDecValue(head);
    }
}