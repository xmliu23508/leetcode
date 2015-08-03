package intersection_of_two_linked_lists;

import common.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alen = 0;
        ListNode a = headA;
        while (a != null) {
            a = a.next;
            alen++;
        }
        int blen = 0;
        ListNode b = headB;
        while (b != null) {
            b = b.next;
            blen++;
        }
        a = headA;
        b = headB;
        if (alen < blen) {
            for (int i = 0; i < blen - alen; i++) {
                b = b.next;
            }
        } else if (blen < alen) {
            for (int i = 0; i < alen - blen; i++) {
                a = a.next;
            }
        }
        while (a != null && b != null && a != b) {
            a = a.next;
            b = b.next;
        }
        if (a == null || b == null) {
            return null;
        } else {
            return a;
        }

    }
}
