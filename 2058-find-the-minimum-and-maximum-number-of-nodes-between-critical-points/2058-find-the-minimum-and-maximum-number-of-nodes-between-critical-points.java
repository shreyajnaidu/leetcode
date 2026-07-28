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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode current = head.next;

        int index = 1;

        int firstCritical = -1;
        int prevCritical = -1;
        int lastCritical = -1;

        int min = Integer.MAX_VALUE;

        while (current.next != null) {

            if ((current.val > prev.val && current.val > current.next.val) ||
                (current.val < prev.val && current.val < current.next.val)) {

                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    min = Math.min(min, index - prevCritical);
                }

                prevCritical = index;
                lastCritical = index;
            }

            prev = current;
            current = current.next;
            index++;
        }

        if (firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }

        int max = lastCritical - firstCritical;

        return new int[]{min, max};
    }
}