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
    int position = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        // We will be dealing with position
        int left = kthSmallest(root.left, k);
        if (left != -1) return left;
        if (++position == k) return root.val;
        int right = kthSmallest(root.right, k);
        if (right != -1) return right;
        return -1;
    
    }
}