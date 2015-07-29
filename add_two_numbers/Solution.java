package add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode curr = fakeHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int v = carry;
            if (l1 != null) {
                v += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(v % 10);
            carry = v / 10;
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
