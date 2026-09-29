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
    int res = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root.val, root);
        return res;
        

    }

    private void dfs(int max, TreeNode node) {
        if (node == null) return;

        if (node.val >= max) {
            res++;
            max = node.val;
        }

        dfs(max, node.left);
        dfs(max, node.right);
    }
}
