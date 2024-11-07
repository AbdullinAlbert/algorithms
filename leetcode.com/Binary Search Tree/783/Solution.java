class Solution {

    class Stack {
        Element tail = null;

        class Element {
            Element previous;

            int data;

            Element(int data) {
                this.data = data;
            }
        }

        void push(int data) {
            if (tail == null) tail = new Element(data);
            else {
                Element e = new Element(data);
                e.previous = tail;
                tail = e;
            }
        }

        int pop() {
            int data = tail.data;
            tail = tail.previous;
            return data;
        }

        boolean isEmpty() {
            return tail == null;
        }
    }
    public int minDiffInBST(TreeNode root) {
        Stack stack = new Stack();
        traverse(root, stack);
        int first = stack.pop();
        int difference = 100_001;
        do {
            int second = stack.pop();
            int cd = Math.abs(first - second);
            if (cd < difference) difference = cd;
            first = second;
        } while (!stack.isEmpty());
        return difference;
    }

    void traverse(TreeNode treeNode, Stack stack) {
        if (treeNode != null) {
            traverse(treeNode.right, stack);
            stack.push(treeNode.val);
            traverse(treeNode.left, stack);
        }
    }
}