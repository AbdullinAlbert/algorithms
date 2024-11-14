class Solution {

    Node head = null;
    Node traversedNode = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        traverse(root);
        Node tail = head;
        while (tail.right != null) tail = tail.right;
        tail.right = head;
        head.left = tail;
        return head;
    }

    void traverse(Node node) {
        if (node != null) {
            traverse(node.left);
            if (traversedNode == null) head = node;
            else {
                traversedNode.right = node;
                node.left = traversedNode;
            }
            traversedNode = node;
            traverse(node.right);
        }
    }

}