public class Solution {

    class Element {
        ListNode listNode;
        Element next;

        Element(ListNode listNode) {
            this.listNode = listNode;
        }
    }

    int tableSize = 512;

    Element[] table = new Element[tableSize];

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode resNode;
            if ((resNode = put(currentNode)) != null) return resNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    private ListNode put(ListNode node) {
        int index = hash(node) & (tableSize - 1);
        Element e;
        if ((e = table[index]) == null) {
            table[index] = new Element(node);
            return null;
        }
        while (e.next != null) {
            if (e.listNode.equals(node)) return e.listNode;
            e = e.next;
        }
        e.next = new Element(node);
        return null;
    }

    private int hash(ListNode node) {
        int h;
        return (h = node.hashCode()) ^ (h >>> 16);
    }

}
