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
    public int position = 1;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int leftInOrder = kthSmallest(root.left, k);
        if (leftInOrder != -1) return leftInOrder;
        if (position++ == k) return root.val;
        return kthSmallest(root.right, k);
    }
}