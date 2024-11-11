public class Solution {

    static class Pair {
        TreeNode first = null;
        TreeNode second = null;
    }

    Pair p = null;

    TreeNode currentPassedNode = null;

    public void recoverTree(TreeNode root) {
        p = new Pair();
        traverse(root);
        int h = p.first.val;
        p.first.val = p.second.val;
        p.second.val = h;
    }

    void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            if (currentPassedNode != null && currentPassedNode.val > node.val) {
                if (p.first == null) p.first = currentPassedNode;
                p.second = node;
            }
            currentPassedNode = node;
            traverse(node.right);
        }
    }
}
