package reverse_nodes_in_k_group;

import common.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int i = 1;
        while (curr != null && i < k) {
            curr = curr.next;
            i++;
        }
        if (curr == null) {
            return head;
        } else {
            ListNode newHead = curr;
            ListNode tail = reverseKGroup(curr.next, k);
            curr = head;
            ListNode next = curr.next;
            head.next = tail;
            for (i = 1; i < k; i++) {
                ListNode tmp = next.next;
                next.next = curr;
                curr = next;
                next = tmp;
            }
            return newHead;
        }
    }
}