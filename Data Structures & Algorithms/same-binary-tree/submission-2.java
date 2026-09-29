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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> sp = new Stack<>();
        Stack<TreeNode> sq = new Stack<>();

        sp.push(p);
        sq.push(q);

        while (!sp.isEmpty() && !sq.isEmpty()) {
            TreeNode n1 = sp.pop();
            TreeNode n2 = sq.pop();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            
            sp.push(n1.left);
            sq.push(n2.left);

            sp.push(n1.right);
            sq.push(n2.right);
        }

        return true;
    }
}
