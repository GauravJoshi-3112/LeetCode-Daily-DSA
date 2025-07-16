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
    int bottom = 0;
    int bottomLeftValue = 0;
    public void findBottomLeftValueDFS(TreeNode root, int level) {
        if (root == null) return;
        if (level > bottom) {
            bottom = level;
            bottomLeftValue = root.val;
        }
        findBottomLeftValueDFS(root.left, level+1);
        findBottomLeftValueDFS(root.right, level+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        bottomLeftValue = root.val;
        findBottomLeftValueDFS(root, 0);
        return bottomLeftValue;
    }
}