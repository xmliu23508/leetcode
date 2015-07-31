package merge_k_sorted_list;

import java.util.Comparator;
import java.util.PriorityQueue;

import common.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(11,
                new Comparator<ListNode>() {
                    public int compare(ListNode x, ListNode y) {
                        return x.val - y.val;
                    };
                });

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode fakeHead = new ListNode(-1);
        ListNode curr = fakeHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}