package common;
public class ListNode {
	public int val;
	public ListNode next;

	@Override
	public String toString() {
		return new Integer(val).toString();
	}

	public ListNode(int x) {
		val = x;
	}
	
	
}
