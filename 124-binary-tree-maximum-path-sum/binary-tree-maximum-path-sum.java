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
    public int maxSum = -1001;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        maxPathSumHelp(root);
        return maxSum;
    }
    public int maxPathSumHelp(TreeNode root) {
        int leftMaxPathSum = 0;
        int rightMaxPathSum = 0;
        if (root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        else if (root.left == null) {
            rightMaxPathSum = maxPathSumHelp(root.right);
            maxSum = Math.max(Math.max(rightMaxPathSum+root.val,root.val),maxSum);
        } else if (root.right == null) {
            leftMaxPathSum = maxPathSumHelp(root.left);
            maxSum = Math.max(Math.max(leftMaxPathSum+root.val,root.val),maxSum);
        }
        else {
            leftMaxPathSum = maxPathSumHelp(root.left);
            rightMaxPathSum = maxPathSumHelp(root.right);
            maxSum = Math.max(Math.max(Math.max(Math.max(Math.max(leftMaxPathSum+root.val,leftMaxPathSum),Math.max(rightMaxPathSum+root.val,rightMaxPathSum)),root.val),leftMaxPathSum+rightMaxPathSum+root.val),maxSum);
        }
        return Math.max(Math.max(leftMaxPathSum+root.val,rightMaxPathSum+root.val),root.val);
    }
}