class Solution {

    class List {

        Node first;
        Node last;

        int size = 0;

        class Node {
            Node next;
            int val;

            Node(int val) {
                this.val = val;
            }
        }

        void add(int val) {
            if (first == null) {
                first = new Node(val);
                last = first;
            } else {
                last.next = new Node(val);
                last = last.next;
            }
            size++;           
        }
    }


    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder(s);
        char one = '1';
        char zero = '0';
        List list = new List();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == one) {
                list.add(i);
                sb.setCharAt(i, zero);
            }
        }
		
        int i = 0;
        List.Node currentNode = list.first;
        do {
            if (i == 0) sb.setCharAt(s.length() - 1, one);
            else sb.setCharAt(i - 1, one);
            i++;
            currentNode = currentNode.next;
        } while (currentNode != null);
		
        return sb.toString();
    }
	
}