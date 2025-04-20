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
    public TreeNode buildTreeH(int[] preorder, int pStart, int pEnd, int [] inorder, int iStart, int iEnd) {
        if (pStart >= pEnd || iStart >= iEnd ) return null;

        // Create Head Node of the Sub Tree
        TreeNode head = new TreeNode(preorder[pStart]);

        // Count i
        int iCount = 0;
        while (iCount < iEnd - iStart && inorder[iStart+iCount] != head.val) {
            iCount++;
        }

        head.left  = buildTreeH(preorder,pStart+1,pStart+iCount+1,inorder,iStart,iStart+iCount);
        head.right = buildTreeH(preorder,pStart+iCount+1,pEnd,inorder,iStart+iCount+1,iEnd);

        return head;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeH(preorder,0,preorder.length,inorder,0,inorder.length);
    }
}