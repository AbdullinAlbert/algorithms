class Solution {

    class MyList {

        Node first;
        Node last;

        class Node  {

            static int length = 26;

            Node next;

            char[] val = new char[length];

            int lastIndex;
        }

        private int hash(char c) {
            return c % Node.length;
        }

        Node contains(char c) {
            if (first == null) return null;
            Node currentNode = first;
            while (currentNode != null) {
                if (currentNode.val[hash(c)] != 0) break;
                currentNode = currentNode.next;
            }
            return currentNode;
        }

        void gainPartitionFrom(Node node, int index) {
            Node currentNode = node.next;
            while (currentNode != null) {
                for (int i = 0; i < currentNode.val.length; i++) {
                    char c = currentNode.val[i];
                    if (c != 0) node.val[hash(c)] = c;
                }
                currentNode = currentNode.next;
            }
            node.next = null;
            last = node;
            node.lastIndex = index;
        }

        void add(char c, int index) {
            if (first == null) {
                first = new Node();
                first.val[hash(c)] = c;
                first.lastIndex = index;
                last = first;
            } else {
                last.next = new Node();
                last = last.next;
                last.val[hash(c)] = c;
                last.lastIndex = index;
            }
        }

    }

    public List<Integer> partitionLabels(String s) {
        MyList list = new MyList();
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            MyList.Node node = list.contains(s.charAt(i));
            if (node != null) {
                list.gainPartitionFrom(node, i);
            } else list.add(s.charAt(i), i);
        }
        int previousIndex = -1;
        MyList.Node currentNode = list.first;
        while (currentNode != null) {
            int size = currentNode.lastIndex - previousIndex;
            res.add(size);
            previousIndex = currentNode.lastIndex;
            currentNode = currentNode.next;
        }
        return res;
    }
}