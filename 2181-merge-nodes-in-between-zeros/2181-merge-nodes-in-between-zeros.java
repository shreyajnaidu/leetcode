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
    public ListNode mergeNodes(ListNode head) {

        ListNode result = new ListNode(0);   // Dummy node
        ListNode temp1 = result;
        ListNode temp2 = head;

        while (temp2 != null) {

            int count = 0;

            if (temp2.val == 0) {

                temp2 = temp2.next;

                while (temp2 != null && temp2.val != 0) {
                    count += temp2.val;
                    temp2 = temp2.next;
                }

                if (count != 0) {
                    ListNode newNode = new ListNode(count);
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }

            } else {
                temp2 = temp2.next;
            }
        }

        return result.next;
    }
}