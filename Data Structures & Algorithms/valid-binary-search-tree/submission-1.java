/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean traverse(TreeNode node, long left, long right) {
        if (node == null) return true;

        if (!(left < node.val && node.val < right)) {
            return false;
        }

        return traverse(node.left, left, node.val) && traverse(node.right, node.val, right);


    }
}
