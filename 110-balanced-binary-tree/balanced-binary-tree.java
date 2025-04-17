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
    public boolean flag = true;
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int lh = depth(root.left);
        if (!flag) return -1;
        int rh = depth(root.right);
        if (!flag) return -1;
        if (Math.abs(lh - rh) > 1) {
            flag = false;
            return -1;
        } 
        return Math.max(lh,rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }
}