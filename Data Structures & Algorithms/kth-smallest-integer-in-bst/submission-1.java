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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;

        while (!s.isEmpty() || node != null) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }

            node = s.pop();
            k--;
            if (k == 0) return node.val;

            node = node.right;
        }

        return -1;

    }

}
