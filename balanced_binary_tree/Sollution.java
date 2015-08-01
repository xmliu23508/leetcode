package balanced_binary_tree;

import common.TreeNode;

public class Sollution {
    public boolean isBalanced(TreeNode root) {
        int[] r = height(root);
        return r[1] == 1;
    }

    /**
     * use array to store result, first item is height, second item is whether
     * the node is balanced.
     */
    int[] height(TreeNode root) {
        int[] result = new int[] { 0, 1 };
        if (root == null) {
            return result;
        } else {
            int[] left = height(root.left);
            int[] right = height(root.right);
            result[0] = Math.max(left[0], right[0]) + 1;
            result[1] = (Math.abs(left[0] - right[0]) <= 1 && left[1] == 1 && right[1] == 1) ? 1
                    : 0;
        }
        return result;
    }
}
