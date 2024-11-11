class Solution {

    TreeNode previousNode = null;

    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        checkToValid(root);
        return res;
    }

    private void checkToValid(TreeNode node) {
        if (node != null) {
            checkToValid(node.left);
            if (!res) return;
            else if (previousNode == null) previousNode = node;
            else if (previousNode.val >= node.val) {
                res = false;
                return;
            } else previousNode = node;
            checkToValid(node.right);
        }
    }
}