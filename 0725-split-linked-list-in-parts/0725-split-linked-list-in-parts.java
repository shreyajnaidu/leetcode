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
    public ListNode[] splitListToParts(ListNode head, int k) {
    int length = 0;
    ListNode temp = head;
    while (temp != null) {
        length++;
        temp = temp.next;
    }
    int base = length / k;
    int extra = length % k;
    ListNode[] lists = new ListNode[k];
    temp = head;
    for (int i = 0; i < k; i++) {
        int size = base;
        if (extra > 0) {
            size++;
            extra--;
        }
        if (size == 0) {
            lists[i] = null;
            continue;
        }
        lists[i] = temp;
        for (int j = 1; j < size; j++) {
            temp = temp.next;
        }
        ListNode next = temp.next;
        temp.next = null;
        temp = next;
    }

    return lists;
}
}