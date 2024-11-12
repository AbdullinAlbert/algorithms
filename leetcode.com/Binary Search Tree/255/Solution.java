class Solution {

    TreeNode root;

    boolean res = true;

    int currentIndex = 0;
    public boolean verifyPreorder(int[] preorder) {
        for (int val : preorder) {
            if (root == null) root = new TreeNode(val);
            else addNode(root, val);
        }
        checkOrder(root, preorder);
        return res;
    }

    void checkOrder(TreeNode node, int[] preorder) {
        if (node != null) {
            if (preorder[currentIndex] == node.val) {
                currentIndex++;
                checkOrder(node.left, preorder);
                if (!res) return;
                checkOrder(node.right, preorder);
            } else res = false;
        }
    }

    void addNode(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right == null) node.right = new TreeNode(val);
            else addNode(node.right, val);
        } else {
            if (node.left == null) node.left = new TreeNode(val);
            else addNode(node.left, val);
        }
    }
}