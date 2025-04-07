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
    public TreeNode searchBST(TreeNode root, int val) {
        // Base Case
        if (root == null) return root; // root does'nt exists return null;
        // Check if Root Equals Target Node
        if (root.val == val) return root; // Return Root Node
        else if (root.val > val) return searchBST(root.left, val); // Use recursion in Left SubTree
        else return searchBST(root.right, val);
    }
}