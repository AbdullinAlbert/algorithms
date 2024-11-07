public class Solution {

    static class Stack<T> {

        int length = 0;
        Element<T> tail = null;

        static class Element<T> {
            Element<T> previous = null;

            T data;

            Element(T data) {
                this.data = data;
            }
        }

        void push(T t) {
            if (tail == null) tail = new Element<>(t);
            else {
                Element<T> element = new Element<>(t);
                element.previous = tail;
                tail = element;
            }
            length++;
        }

        T pop() {
            T data = tail.data;
            tail = tail.previous;
            return data;
        }

    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        traverseTree(root, stack);
        int[] a = new int[stack.length];
        for (int i = a.length - 1; i>= 0; i--) a[i] = stack.pop();
        int i = 0;
        int j = a.length - 1;
        while (i != j) {
            int sum = a[i] + a[j];
            if (sum == k) return true;
            if (sum > k) j--;
            else i++;
        }
        return false;
    }

    private void traverseTree(TreeNode treeNode, Stack<Integer> stack) {
        if (treeNode != null) {
            traverseTree(treeNode.left, stack);
            stack.push(treeNode.val);
            traverseTree(treeNode.right, stack);
        }
    }
}
