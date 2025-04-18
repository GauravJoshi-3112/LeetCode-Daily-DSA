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
    boolean validSubRoot = false;

    public boolean validate(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return validate(p.left,q.left) && validate(p.right,q.right);
    }

    public TreeNode subTreeNode(TreeNode root, TreeNode subRoot) {
        if (root == null) return null;

        TreeNode ifLeft = subTreeNode(root.left, subRoot);
        if (ifLeft != null && validSubRoot) {
            return ifLeft;
        }

        TreeNode ifRight = subTreeNode(root.right, subRoot);
        if (ifRight != null && validSubRoot) {
            return ifLeft;
        }

        if (root.val == subRoot.val && !validSubRoot) {
            validSubRoot = validate(root, subRoot);
            if (validSubRoot) return root;
        }

        return null;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        subTreeNode(root, subRoot);
        return validSubRoot;
    }
}