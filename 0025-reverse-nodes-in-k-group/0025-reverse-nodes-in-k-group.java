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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (true) {

            ListNode temp = prev;
            for (int i = 0; i < k; i++) {
                temp = temp.next;
                if (temp == null) {
                    return dummy.next;
                }
            }

            ListNode end = temp.next;

            ListNode curr = prev.next;
            ListNode before = end;

            while (curr != end) {
                ListNode next = curr.next;
                curr.next = before;
                before = curr;
                curr = next;
            }

            ListNode oldStart = prev.next;

            prev.next = before;
            prev = oldStart;
        }
    }
}