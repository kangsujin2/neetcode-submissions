/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @param {TreeNode} subRoot
     * @return {boolean}
     */
    isSubtree(root: TreeNode | null, subRoot: TreeNode | null): boolean {
        if (subRoot === null) return true;
        if (root === null) return false;
        if (isSame(root, subRoot)) return true;
        return this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);

        function isSame(node: TreeNode | null, subNode: TreeNode | null): boolean {
            if (node === null && subNode === null) return true;
            if (node === null || subNode === null) return false;
            if (node.val != subNode.val) return false;
            return isSame(node.left, subNode.left) && isSame(node.right, subNode.right);
        }
    }
}
