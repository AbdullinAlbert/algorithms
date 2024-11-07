class Solution {

    int sum = 0;
    boolean isNeedReturn = false;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    void traverse(TreeNode node, int low, int high) {
        if (node != null) {
            traverse(node.left, low, high);
            if (node.val >= low && node.val <= high) sum += node.val;
            traverse(node.right, low, high);
        }
    }
}