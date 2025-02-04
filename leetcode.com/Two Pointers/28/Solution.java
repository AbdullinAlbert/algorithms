class Solution {

    class MyList {

        Node first;

        class Node {
        
            Node next;

            int index;

            Node(int index) {
                this.index = index;
            }

        }

        void add(int index) {
            if (first == null) {
                first = new Node(index);
                return;
            }
            Node currentNode = first;
            while (currentNode.next != null) {
                if (currentNode.index == index) return;
                currentNode = currentNode.next;
            }
            if (currentNode.index == index) return;
            currentNode.next = new Node(index);
        }

        int removeFirst() {
            if (first == null) return -1;
            int res = first.index;
            first = first.next;
            return res;
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int res = -1;
        int j = 0;
        int i = 0;
        MyList list = new MyList();
        boolean isFirst = true;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (isFirst) isFirst = false;
                else list.add(i);
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (res == -1) res = i;
                i++;
                j++;
                if (j == needle.length()) return res;
            } else {
                int previousIndex = list.removeFirst();
                if (previousIndex != -1) {
                    i = previousIndex + 1;
                    j = 1;
                    res = previousIndex;
                } else {
                    i++;
                    j = 0;
                    res = -1;
                }
            }
        }
        return -1;
    }
}