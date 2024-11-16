class Solution {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.right);
            sum += node.val;
            node.val = sum;
            traverse(node.left);
        }
    }
}