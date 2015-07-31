package swap_pairs;

import common.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode next = head.next;
            ListNode tmp = next.next;
            next.next = head;
            head.next = swapPairs(tmp);
            return next;
        }
    }
}