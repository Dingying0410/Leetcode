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

    String NULL = "null";
    String SPLITTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return treeToStr(root);
    }

    public String treeToStr(TreeNode root) {
        if (root == null)
            return NULL + SPLITTER;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + SPLITTER);
        sb.append(treeToStr(root.left));
        sb.append(treeToStr(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(SPLITTER);
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
        return strToTree(queue);
    }

    public TreeNode strToTree(Queue<String> queue) {
        if (queue.isEmpty())
            return null;
        String val = queue.poll();
        if (val.isEmpty() || val.equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = strToTree(queue);
        root.right = strToTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
