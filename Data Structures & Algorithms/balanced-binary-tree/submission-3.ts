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
     * @return {boolean}
     */
    isBalanced(root: TreeNode | null): boolean {
        if (root === null) return true;

        function depth(node: TreeNode | null): number {
            if (node === null) return 0;

            const leftDepth = depth(node.left);
            if (leftDepth === -1) return -1;

            const rightDepth = depth(node.right);
            if (rightDepth === -1) return -1;

            if (Math.abs(leftDepth - rightDepth) > 1) return -1;

            return Math.max(leftDepth, rightDepth) + 1;
        }

        return depth(root) != -1;
    }
}
