public class Solution {

    HelpTreeNode helpTreeNode;

    class HelpTreeNode {
        HelpTreeNode left;
        HelpTreeNode right;

        int data;
        int frequency = 1;

        HelpTreeNode(int data) {
            this.data = data;
        }

        int add(HelpTreeNode node, int value) {
            if (node.data == value) return ++node.frequency;
            else if (node.data < value) {
                if (node.right == null) {
                    node.right = new HelpTreeNode(value);
                    return node.right.frequency;
                } else return add(node.right, value);
            } else {
                if (node.left == null) {
                    node.left = new HelpTreeNode(value);
                    return node.left.frequency;
                } else return add(node.left, value);
            }
        }
    }

    class Stack {
        private int length = 0;

        private Element tail;

        class Element {
            int data;
            Element previous;

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
            length++;
        }

        int pop() {
            int data = tail.data;
            tail = tail.previous;
            return data;
        }
    }

    int maxFrequency = 0;

    public int[] findMode(TreeNode root) {
        fillHelperBinaryTree(root);
        Stack stack = new Stack();
        putMode(stack, helpTreeNode);
        int[] res = new int[stack.length];
        for (int i = 0; i < res.length; i++) res[i] = stack.pop();
        return res;
    }

    private void fillHelperBinaryTree(TreeNode treeNode) {
        if (treeNode != null) {
            int currentFrequency = putData(treeNode.val);
            if (currentFrequency > maxFrequency) maxFrequency = currentFrequency;
            fillHelperBinaryTree(treeNode.left);
            fillHelperBinaryTree(treeNode.right);
        }
    }

    private int putData(int data) {
        if (helpTreeNode == null) {
            helpTreeNode = new HelpTreeNode(data);
            return helpTreeNode.frequency;
        } else return helpTreeNode.add(helpTreeNode, data);
    }

    void putMode(Stack stack, HelpTreeNode helpTreeNode) {
        if (helpTreeNode != null) {
            if (helpTreeNode.frequency == maxFrequency) stack.push(helpTreeNode.data);
            putMode(stack, helpTreeNode.left);
            putMode(stack, helpTreeNode.right);
        }
    }
}
