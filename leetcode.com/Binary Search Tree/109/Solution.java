public class Solution {

    TreeNode treeNode = null;
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode h = head;
        while (h != null) {
            size++;
            h = h.next;
        }

        int[] a = new int[size];
        int i = 0;
        h = head;
        while (h != null) {
            a[i++] = h.val;
            h = h.next;
        }
        if (size == 0) return treeNode;
        fillTree(a, 0, a.length - 1);
        return treeNode;
    }

    void fillTree(int[] a, int start, int end) {
        int middleIndex = ((end - start) / 2) + start;
        if (treeNode == null) treeNode = new TreeNode(a[middleIndex]);
        else addNode(treeNode, a[middleIndex]);
        if (start >= end) return;
        fillTree(a, start, middleIndex);
        fillTree(a, middleIndex + 1, end);
    }

    void addNode(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right == null) node.right = new TreeNode(val);
            else addNode(node.right, val);
        } else if (node.val > val) {
            if (node.left == null) node.left = new TreeNode(val);
            else addNode(node.left, val);
        }
    }
}
