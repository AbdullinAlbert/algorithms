
class Solution {

    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return res;
    }

    void traverse(TreeNode node, TreeNode p, TreeNode q) {
        if (node != null) {
            if ((node.val < p.val && node.val < q.val) || (node.val > p.val && node.val > q.val)) {
                traverse(node.left, p, q);
                if (res != null) return;
                traverse(node.right, p, q);
            } else res = node;
        }
    }
}

