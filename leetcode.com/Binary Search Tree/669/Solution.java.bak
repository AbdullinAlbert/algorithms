class Solution {

    class Queue {

        Element first = null;

        Element last = null;

        class Element {
            Element next = null;
            int data;

            Element(int data) {
                this.data = data;
            }
        }

        void add(int val) {
            Element e = new Element(val);
            if (first == null) {
                first = e;
                last = first;
            } else {
                last.next = e;
                last = e;
            }
        }
    }

    Queue q = null;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode res = null;
        q = new Queue();
        traverse(root, low, high);
        Queue.Element element = q.first;
        while (element != null) {
            if (res == null) res = new TreeNode(element.data);
            else add(res, element.data);
            element = element.next;
        }
        return res;
    }

    private void add(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right == null) node.right = new TreeNode(val);
            else add(node.right, val);
        } else {
            if (node.left == null) node.left = new TreeNode(val);
            else add(node.left, val);
        }
    }

    private void traverse(TreeNode node, int low, int high) {
        if (node != null) {
            if (node.val >= low && node.val <= high) {
                q.add(node.val);
            }
            traverse(node.left, low, high);
            traverse(node.right, low, high);
        }
    }

}