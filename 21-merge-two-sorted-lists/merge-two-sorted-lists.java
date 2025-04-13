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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a temp merged list head node
        ListNode head = new ListNode(-1);
        ListNode curr = head; // curr points to dummy head node
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while(curr1 != null && curr2 != null) {
            // Till Both List Exists
            if (curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            } 
            curr = curr.next;
        }

        // If any One List Longer than another
        if (curr1 != null) {
            curr.next = curr1;
            curr1 = curr1.next;
        }

        if (curr2 != null) {
            curr.next = curr2;
            curr2 = curr2.next;
        }

        return head.next; // Why next not head as head is dummy node
    }
}