package add_two_numbers;

public class ListNode {
    int val;
    ListNode next;

    @Override
    public String toString() {
        return new Integer(val).toString();
    }

    ListNode(int x) {
        val = x;
    }

}
