class Solution {

    TreeNode successor = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root.val <= p.val) {
            findInorderSuccessor(root.right, p);
            return successor;
        } else {
            findInorderSuccessor(root.left, p);
            return (successor != null) ? successor : root;
        }
    }

    void findInorderSuccessor(TreeNode node, TreeNode p) {
        if (node != null) {
           findInorderSuccessor(node.left, p);
           if (successor != null) return;
           if (node.val > p.val) successor = node;
           else findInorderSuccessor(node.right, p);
        }
    }
}