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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return root;
        TreeNode leftNode = removeLeafNodes(root.left, target);
        TreeNode rightNode = removeLeafNodes(root.right, target);
        if (leftNode == null && rightNode == null && root.val == target) return null;
        else {
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
    }
}