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
    public List<Integer> tree = new ArrayList<>();
    public void rightSideTree(TreeNode root, int level) {
        if (root == null) return;
        if (level > tree.size()) {
            tree.add(root.val);
        }
        rightSideTree(root.right, level+1);
        rightSideTree(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        rightSideTree(root,1);
        return tree;
    }
}