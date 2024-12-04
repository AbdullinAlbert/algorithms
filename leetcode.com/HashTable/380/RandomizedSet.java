import java.util.Random;

class RandomizedSet {

    class List {

        Node first;

        int length = 0;

        class Node {
            int key;
            Node previous;
            Node next;

            Node(int data, Node previous) {
                this.key = data;
                this.previous = previous;
            }
        }

        private boolean add(int val) {
            if (first == null) first = new Node(val, null);
            else {
                Node currentNode = first;
                while (currentNode.next != null) {
                    if (currentNode.key == val) return false;
                    currentNode = currentNode.next;
                }
                if (currentNode.key == val) return false;
                currentNode.next = new Node(val, currentNode);
            }
            length++;
            return true;
        }

        private boolean remove(int val) {
            if (first == null) return false;
            Node currentNode = first;
            while (currentNode.next != null) {
                if (currentNode.key == val) {
                    if (currentNode == first) {
                        first = first.next;
                        first.previous = null;
                    } else {
                        Node prev = currentNode.previous;
                        Node next = currentNode.next;
                        prev.next = next;
                        next.previous = prev;
                    }
                    length--;
                    return true;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key == val) {
                if (currentNode == first) first = null;
                else {
                    Node prev = currentNode.previous;
                    prev.next = null;
                }
                length--;
                return true;
            }
            return false;
        }

        private int getAt(int pos) {
            int currentPos = 0;
            Node currentNode = first;
            while (currentPos < pos) {
                currentNode = currentNode.next;
                currentPos++;
            }
            return currentNode.key;
        }
    }

    int tableSize = 512;

    List[] table = new List[tableSize];

    Random r = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        int index = index(val);
        if (table[index] == null) table[index] = new List();
        return table[index].add(val);
    }

    public boolean remove(int val) {
        int index = index(val);
        if (table[index] == null) return false;
        return table[index].remove(val);
    }

    private int index(int val) {
        return hash(val) & (tableSize - 1);
    }

    public int getRandom() {
        int[] filledCells = new int[tableSize];
        int filledCellsLength = 0;
        for (int i = 0; i < tableSize; i++) {
            if (table[i] == null || (table[i] != null && table[i].length == 0)) continue;
            filledCells[filledCellsLength++] = i;
        }
        int tableIndex = filledCells[r.nextInt(filledCellsLength)];
        int elementPos = r.nextInt(table[tableIndex].length);
        return table[tableIndex].getAt(elementPos);
    }

    private int hash(int key) {
        return key ^ (key >>> 16);
    }
}
