import java.util.Objects;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        traverse(root, sb);
        int i = sb.lastIndexOf(",");
        sb.delete(i, sb.length());
        return sb.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "[]")) return null;
        TreeNode root = null;
        String[] values = data.substring(1, data.length() - 1).split(", ");
        for (String s : values) {
            if (root == null) root = new TreeNode(Integer.parseInt(s));
            else addValue(root, Integer.parseInt(s));
        }
        return root;
    }

    void addValue(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right == null) node.right = new TreeNode(val);
            else addValue(node.right, val);
        } else {
            if (node.left == null) node.left = new TreeNode(val);
            else addValue(node.left, val);
        }
    }

    void traverse(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val).append(", ");
            traverse(node.left, sb);
            traverse(node.right, sb);
        }
    }
}