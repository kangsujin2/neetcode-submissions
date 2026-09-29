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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        traverse(res, 0, root);

        return res;
        
    }

    private void traverse(List<List<Integer>> res, int level, TreeNode cur) {
        if (cur == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(cur.val);

        traverse(res, level + 1, cur.left);
        traverse(res, level + 1, cur.right);
    }
}
