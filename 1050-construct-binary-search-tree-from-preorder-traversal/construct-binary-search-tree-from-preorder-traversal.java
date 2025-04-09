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
    public TreeNode bstFromPreorderAndInorder(int [] preorder,int i1, int j1, int [] inorder,int i2, int j2) {
        if (j1 < i1 || j2 < i2) return null;
        TreeNode root = new TreeNode(preorder[i1]);
        int i = i2;
        while (i <= j2) {
            if (inorder[i] == preorder[i1]) break;  
            i++;
        }

        root.left = bstFromPreorderAndInorder(preorder, i1+1, i1+i-i2, inorder, i2, i-1);
        root.right = bstFromPreorderAndInorder(preorder,i1+i-i2+1, j1, inorder, i+1, j2);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int [] inorder = preorder.clone();
        Arrays.sort(inorder);
        
        // Got both Inorder and PreOrder
        return bstFromPreorderAndInorder(preorder,0,preorder.length-1, inorder, 0, inorder.length-1);
    }
}