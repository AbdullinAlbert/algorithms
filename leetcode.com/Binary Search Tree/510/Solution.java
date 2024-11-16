class Solution {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            Node res = node.right;
            while (res.left != null) res = res.left;
            return res;
        }
        if (node.parent != null) {
            if (node.val < node.parent.val)  return node.parent;
            Node h = node.parent;
            while (h.parent != null) {
                h = h.parent;
                if (h.val > node.val) return h;
            }
        }
        return null;
    }
}

