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
    boolean flag = true;
    public int[] isValidBSTHelp(TreeNode root) {
        if (!flag) return new int [] {root.val, root.val};
        if (root == null) return new int [] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        int [] left = null;
        if (root.left != null) left = isValidBSTHelp(root.left);

        int [] right = null;
        if (root.right != null) right = isValidBSTHelp(root.right);

        if ((left!= null && root.val <= left[1]) || (right != null && root.val >= right[0])) {
            flag = false;
            return new int [] {root.val,root.val};
        } 

        if (left == null) {
            left = new int [] {root.val, root.val};
        }

        if (right == null) {
            right = new int [] {root.val, root.val};
        }

        
        int [] ans = new int[2];
        ans[0] = Math.min(Math.min(left[0],right[0]),root.val);
        ans[1] = Math.max(Math.max(left[1],right[1]),root.val); 
        return ans;
    }

    public boolean isValidBST(TreeNode root) {
        // Base case
        isValidBSTHelp(root);
        return flag;
    }
}