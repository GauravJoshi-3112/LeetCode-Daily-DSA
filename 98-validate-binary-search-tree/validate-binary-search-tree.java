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

class Result {
    boolean isValid;
    int min;
    int max;
    Result (boolean isValid, int min, int max) {
        this.isValid = isValid;
        this.min = min;
        this.max = max;
    }
}

class Solution {
    public Result isBST(TreeNode root) {
        if (root == null) return new Result(true,Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = isBST(root.left);
        Result right = isBST(root.right);

        if (!left.isValid || !right.isValid || (root.left != null && left.max >= root.val) || (root.right != null && right.min <= root.val)) {
            return new Result(false,0,0);
        }

        int min = root.left != null ? left.min : root.val;
        int max = root.right != null ? right.max : root.val;

        return new Result(true, min, max);
    }
    public boolean isValidBST(TreeNode root) {
        return isBST(root).isValid;
    }
}