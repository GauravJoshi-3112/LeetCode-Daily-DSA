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

    public ListNode reverseList(ListNode head, ListNode tail, int count) {
        ListNode prev = null;
        ListNode next = head.next;
        ListNode curr = head;
        int index = 0;
        while (index < count) {
            if (prev == null) {
                prev = curr;
                curr = curr.next;
            } else {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            index++;
        }

        head.next = next;
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = right - left + 1;
        if (count <= 1) return head;

        ListNode prev = new ListNode(-1,head);
        ListNode curr = head;
        ListNode leftNode = head;
        int index = 1;
        while (index < right) {
            if (index == left) leftNode = curr;
            else if (index < left) prev = curr;
            curr = curr.next;
            index++;
        } 

        if (head != leftNode) {
            prev.next = reverseList(leftNode, curr, count);
            return head;
        } else return reverseList(leftNode, curr, count);
    }
}