class BSTIterator {

    class Stack {

        class Element {
            TreeNode data = null;

            Element previous = null;

            Element(TreeNode treeNode) {
                data = treeNode;
            }
        }
        Element tail = null;

        Stack(TreeNode element) {
            push(element);
            TreeNode h = element.left;
            while (h != null) {
                push(h);
                h = h.left;
            }
        }

        private void push(TreeNode treeNode) {
            Element newElement = new Element(treeNode);
            if (tail == null) tail = newElement;
            else {
                newElement.previous = tail;
                tail = newElement;
            }
        }

        TreeNode pop() {
            TreeNode popped = tail.data;
            tail = tail.previous;
            TreeNode hr = popped.right;
            if (hr != null) {
                push(hr);
                TreeNode h = hr.left;
                while (h != null) {
                    push(h);
                    h = h.left;
                }
            }
            return popped;
        }

        boolean hasNext() {
            return tail != null;
        }
    }

    Stack stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack(root);
    }

    public int next() {
        return stack.pop().val;
    }

    public boolean hasNext() {
        return stack.hasNext();
    }
}