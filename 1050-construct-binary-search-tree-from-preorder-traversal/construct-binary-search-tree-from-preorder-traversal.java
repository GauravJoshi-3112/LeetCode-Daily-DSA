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
    public TreeNode bstFromPreorder(int [] preorder, int i, int j) {
        if (i >= j) return null;
        TreeNode root = new TreeNode(preorder[i]);
        int jN = i+1;
        while (jN < j) {
            if (preorder[jN] > root.val) break;
            jN++;
        }

        root.left = bstFromPreorder(preorder, i+1, jN);
        root.right = bstFromPreorder(preorder, jN, j);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length);
    }
}