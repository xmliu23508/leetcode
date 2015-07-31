package merge_two_list;

import common.ListNode;


public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode curr = fakeHead;
        while(l1!=null && l2!=null) {
            if (l1.val<l2.val) {
                curr.next = l1;
                l1=l1.next;
            }
            else {
                curr.next = l2;
                l2=l2.next;
            }
            curr= curr.next;
        }
        if (l1!=null) {
            curr.next=l1;
        }
        else {
            curr.next=l2;
        }
        return fakeHead.next;
    }
}