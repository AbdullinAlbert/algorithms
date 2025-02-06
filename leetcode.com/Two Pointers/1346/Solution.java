class Solution {

    class Node {
        Node next;
        int val;
        int index;

        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    int length = 512;

    Node[] table = new Node[length];

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) add(arr[i], i);
        for (int i = 0; i < arr.length; i++) {
            int res = arr[i] * 2;
            if (contains(res, i)) return true;
        }
        return false;
    }

    void add(int n, int i) {
        int index = index(n);
        if (table[index] == null) table[index] = new Node(n, i);
        else {
            Node currentNode = table[index];
            while (currentNode.next != null) {
                if (currentNode.val == n) return;
                currentNode = currentNode.next;
            }
            if (currentNode.val == n) return;
            currentNode.next = new Node(n, i);
        }
    }

    boolean contains(int n, int i) {
        int index = index(n);
        Node currentNode = table[index];
        if (currentNode == null) return false;
        while (currentNode.next != null) {
            if (currentNode.val == n && currentNode.index != i) return true;
            currentNode = currentNode.next;
        }
        return ((currentNode.val == n) && (currentNode.index != i));
    }

    int index(int n) {
        int hash = hash(n);
        return hash & (length - 1);
    }

    int hash(int n) {
        return n ^ (n >>> 16);
    }

}