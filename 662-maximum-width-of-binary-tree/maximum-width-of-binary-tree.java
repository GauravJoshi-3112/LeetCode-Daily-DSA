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
class Pair {
    int index;
    TreeNode node;
    Pair(int index, TreeNode node) {
        this.index = index;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxwidth = 0;
        if (root == null) return maxwidth;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            int size = queue.size();

            // An Empty size is not possible
            int leftIndex = queue.peek().index;
            int rightIndex = queue.peek().index;

            for(int i=0; i<size; i++) {
                TreeNode node = queue.peek().node;
                int index = queue.poll().index;

                rightIndex = Math.max(rightIndex, index);
                
                if (node.left != null) queue.offer(new Pair(2*index + 1, node.left));
                if (node.right != null) queue.offer(new Pair(2*index + 2, node.right));
            }

            maxwidth = Math.max(maxwidth, rightIndex - leftIndex + 1);
        }
        
        return maxwidth;
    }
}