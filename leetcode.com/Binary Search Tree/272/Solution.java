import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {

    class Pair {
        int val;
        double diff;

        Pair(int val, double diff) {
            this.val = val;
            this.diff = diff;
        }
    }

    class Stack {

        int length = 0;
        Element tail = null;
        class Element {
            Pair val;

            Element previous;

            Element(Pair val) {
                this.val = val;
            }
        }

        void push(Pair val) {
            Element e = new Element(val);
            if (tail == null) tail = e;
            else {
                e.previous = tail;
                tail = e;
            }
            length++;
        }

        Pair pop() {
            Pair val = tail.val;
            tail = tail.previous;
            return val;
        }

    }

    Stack stack;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        stack = new Stack();
        traverse(root, target);
        Pair[] a = new Pair[stack.length];
        for (int i = 0; i < a.length; i++) a[i] = stack.pop();
        quickSort(a, 0, a.length - 1);
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) res.add(a[i].val);
        return res;
    }

    void quickSort(Pair[] a, int start, int end) {
        if (start >= end) return;
        int p = partition(a, start, end);
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    Random r = new Random();

    int partition(Pair[] a, int start, int end) {
        int p = r.nextInt(end - start) + start;

        Pair h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;

        for (int j = start + 1; j <= end; j++) {
            if (a[j].diff < a[start].diff) {
                h = a[less + 1];
                a[less + 1] = a[j];
                a[j] = h;
                less++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return less;
    }

    void traverse(TreeNode node, double target) {
        if (node != null) {
            traverse(node.right, target);
            double d = Math.abs(node.val - target);
            stack.push(new Pair(node.val, d));
            traverse(node.left, target);
        }
    }
}