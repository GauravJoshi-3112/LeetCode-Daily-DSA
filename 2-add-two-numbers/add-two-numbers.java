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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        int index = 0, value = 0;
        while (curr1 != null && curr2 != null) {
            value = curr1.val + curr2.val + index;
            if (value >= 10) {
                value = value % 10;
                index = 1;
            } else {
                index = 0;
            }
            curr.next = new ListNode(value);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            value = curr1.val + index;
            if (value >= 10) {
                value = value % 10;
                index = 1;
            } else {
                index = 0;
            }
            curr.next = new ListNode(value);
            curr = curr.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            value = curr2.val + index;
            if (value >= 10) {
                value = value % 10;
                index = 1;
            } else {
                index = 0;
            }
            curr.next = new ListNode(value);
            curr = curr.next;
            curr2 = curr2.next;
        }

        if (index != 0) {
            curr.next = new ListNode(index);
        }

        return head.next;

    }
}