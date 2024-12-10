class Solution {

    private final int tableSize = 1024;

    class Node {
        int key;
        String value;

        Node next;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    class List {
        Node first;
        Node last;

        List(int key, String value) {
            first = new Node(key, value);
            last = first;
        }

        public void add(int key, String value) {
            last.next = new Node(key, value);
            last = last.next;
        }

        public String get(int key) {
            Node currentNode = first;
            while (currentNode != null) {
                if (currentNode.key == key) return currentNode.value;
                currentNode = currentNode.next;
            }
            return "";
        }
    }

    List[] hashTable = new List[tableSize];

    public String[] findRelativeRanks(int[] score) {
        int[] ha = new int[score.length + 1];
        for (int i = 0; i < score.length; i++) ha[i + 1] = score[i];

        int middle = (ha.length / 2);

        for (int i = 1; i < ha.length; i++) {

            for (int j = middle; j >= i; j--) push(ha, j, i, middle);

            middle++;

            String value = switch (i) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> String.valueOf(i);
            };
            add(ha[i], value);
        }

        String[] res = new String[score.length];
        for (int i = 0; i < res.length; i++) {
            int key = score[i];
            int index = index(key);
            res[i] = hashTable[index].get(key);
        }

        return res;
    }

    private void add(int key, String value) {
        int index = index(key);
        List list;
        if ((list = hashTable[index]) == null) hashTable[index] = new List(key, value);
        else list.add(key, value);
    }

    private int index(int key) {
        int h = (key) ^ (key >>> 16);
        return h & (tableSize - 1);
    }

    private void push(int[] a, int currentPos, int shift, int middle) {
        int hp1 = (currentPos * 2) - shift;
        int hp2 = hp1 + 1;
        if (hp2 < a.length) {
            int hp = (a[hp1] < a[hp2]) ? hp2 : hp1;
            if (a[currentPos] < a[hp]) {
                int h = a[currentPos];
                a[currentPos] = a[hp];
                a[hp] = h;
                if (hp < middle) push(a, hp, shift, middle);
            }
        } else if (hp1 < a.length && a[currentPos] < a[hp1]) {
            int h = a[currentPos];
            a[currentPos] = a[hp1];
            a[hp1] = h;
        }
    }

}
