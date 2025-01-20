class Solution {

    class Set {

        Node first;

        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        boolean add(int val) {
            if (first == null) {
                first = new Node(val);
                return true;
            }
            Node h = first;
            while (h.next != null) {
                if (h.val == val) return false;
                h = h.next;
            }
            if (h.val == val) return false;
            h.next = new Node(val);
            return true;
        }

        void clear() {
            first = null;
        }
    }

    Set set = new Set();

    public int numberCount(int a, int b) {
        int res = 0;
        for (int i = a; i <= b; i++) {
            if (isUnique(i)) res++;
        }
        return res;
    }

    private boolean isUnique(int n) {
        set.clear();
        while (n > 0) {
            int c = n % 10;
            if (set.add(c)) n = n / 10;
            else return false;
        }
        return true;
    }
}