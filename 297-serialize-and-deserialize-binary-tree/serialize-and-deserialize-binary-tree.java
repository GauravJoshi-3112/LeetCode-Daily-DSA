/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode elem = queue.poll();
            if (elem == null) {
                if (queue.isEmpty()) sb.append("N");
                else sb.append("N,");
                continue;
            } else {
                sb.append(elem.val + ",");
                queue.offer(elem.left);
                queue.offer(elem.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] value = data.split(",");
        if(value.length <= 0 || value[0].equalsIgnoreCase("N")) {
            return null;
        } 
        Queue<TreeNode> queue  = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.valueOf(value[0]));
        queue.offer(head);
        for(int i=1; i<value.length && !queue.isEmpty(); i++) {
            TreeNode parent = queue.poll();
            if(value[i].equalsIgnoreCase("N")) {
                parent.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.valueOf(value[i]));
                parent.left = left;
                queue.offer(left);
            }

            if(value[++i].equalsIgnoreCase("N")) {
                parent.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.valueOf(value[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));