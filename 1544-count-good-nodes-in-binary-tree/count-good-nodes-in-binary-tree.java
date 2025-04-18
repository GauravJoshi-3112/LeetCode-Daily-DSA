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
    public int goodNodesHelp(TreeNode root, int max) {
        if (root == null) return 0;
        max = Math.max(root.val, max);
        int lGoodNodes = goodNodesHelp(root.left, max);
        int rGoodNodes = goodNodesHelp(root.right, max);
        return root.val == max ? lGoodNodes + rGoodNodes + 1 : lGoodNodes + rGoodNodes;
    } 

    public int goodNodes(TreeNode root) {
        return goodNodesHelp(root, Integer.MIN_VALUE);
    }
}