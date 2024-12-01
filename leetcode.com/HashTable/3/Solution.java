public class Solution {

    class Node {
        int index;
        int key;

        Node next = null;

        Node(int index, int key, Node next) {
            this.index = index;
            this.key = key;
            this.next = next;
        }

    }

    int tableSize = 64;

    Node[] table = new Node[tableSize];

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int currentRes = res;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int hi;
            if ((hi = contains(c)) != -1) {
                if (currentRes > res) res = currentRes;
                currentRes = 0;
                resetTable();
                i = hi + 1;
            } else {
                add(i, c);
                currentRes++;
                i++;
            }
        }
        if (currentRes > res) res = currentRes;
        return res;
    }

    private int contains(char c) {
        int hash = c & (tableSize - 1);
        Node currentNode;
        if ((currentNode = table[hash]) == null) return -1;
        while (currentNode != null) {
            if (currentNode.key == c) return currentNode.index;
            currentNode = currentNode.next;
        }
        return -1;
    }

    private void add(int index, char key) {
        int hash = key & (tableSize - 1);
        Node currentNode;
        if ((currentNode = table[hash]) == null) {
            table[hash] = new Node(index, key, null);
        } else {
            while (currentNode.next != null) currentNode = currentNode.next;
            currentNode.next = new Node(index, key, null);
        }
    }

    private void resetTable() {
        for (int i = 0; i < tableSize; i++) table[i] = null;
    }
}
