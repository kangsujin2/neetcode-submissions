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
     * @return {number}
     */
    diameterOfBinaryTree(root: TreeNode | null): number {
        let diameter = 0;

        function depth(node: TreeNode | null): number {
            if (node === null) return 0;

            const left = depth(node.left);
            const right = depth(node.right);

            diameter = Math.max(diameter, left + right);

            return Math.max(left, right) + 1;
        }

        depth(root);
        return diameter;
    }
}
