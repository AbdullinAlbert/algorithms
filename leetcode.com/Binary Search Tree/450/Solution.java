class Solution {

    TreeNode predecessor = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        delete(root, key);
        if (predecessor == null) return null;
        return root;
    }

    private void delete(TreeNode node, int key) {
        if (node != null) {
            if (node.val < key) {
                predecessor = node;
                deleteNode(node.right, key);
            }
            else if (node.val > key) {
                predecessor = node;
                deleteNode(node.left, key);
            }
            else {
                TreeNode successor = getMostLeftNodeAtRightSubTree(node.right);
                if (successor != null) {
                    if (successor.left != null) {
                        node.val = successor.left.val;
                        successor.left = successor.left.right;
                    } else {
                        node.val = successor.val;
                        node.right = successor.right;
                    }
                    predecessor = node;
                    return;
                }
                successor = getMostRightAtLeftSubTree(node.left);
                if (successor != null) {
                    if (successor.right != null) {
                        node.val = successor.right.val;
                        successor.right = successor.right.left;
                    } else {
                        node.val = successor.val;
                        node.left = successor.left;
                    }
                    predecessor = node;
                    return;
                }
                if (predecessor == null) return;
                if (predecessor.val > node.val) predecessor.left = null;
                else predecessor.right = null;
            }
        }
    }

    private TreeNode getMostLeftNodeAtRightSubTree(TreeNode node) {
        if (node == null) return null;
        TreeNode res = node;
        while (res.left != null && res.left.left != null) res = res.left;
        return res;
    }

    private TreeNode getMostRightAtLeftSubTree(TreeNode node) {
        if (node == null) return null;
        TreeNode res = node;
        while (res.right != null && res.right.right != null) res = res.right;
        return res;
    }

}