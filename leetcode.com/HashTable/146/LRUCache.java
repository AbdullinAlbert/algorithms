class LRUCache {


    class Element {

        int key;

        Element previous;

        Element next;

        Element(int key, Element previous) {
            this.key = key;
            this.previous = previous;
        }
    }

    class Node {
        int key;
        int value;

        Node next;

        Node previous;

        Node(int key, int value, Node previous) {
            this.key = key;
            this.value = value;
            this.previous = previous;
        }

    }

    private final int tableSize = 1024;

    private final int capacity;

    private int usedCapacity = 0;

    Element first = null;

    Element last = null;

    Node[] table = new Node[tableSize];

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int index = index(key);
        Node currentNode;
        if ((currentNode = table[index]) == null) return -1;
        while (currentNode != null) {
            if (currentNode.key == key) {
                updateLRU(key);
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        int index = index(key);
        Node currentNode;
        if ((currentNode = table[index]) == null) {
            table[index] = new Node(key, value, null);
            addElement(key);
        } else {
            while (currentNode.next != null) {
                if (currentNode.key == key) {
                    currentNode.value = value;
                    updateLRU(key);
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key == key) {
                currentNode.value = value;
                updateLRU(key);
            } else {
                currentNode.next = new Node(key, value, currentNode);
                addElement(key);
            }
        }
    }

    private void updateLRU(int key) {
        Element currentElement = first;
        while (currentElement.key != key) currentElement = currentElement.next;
        if (currentElement == first && currentElement != last) {
            first = first.next;
            currentElement.previous = last;
            last.next = currentElement;
            last = last.next;
            last.next = null;
        } else if (currentElement != last) {
            Element prev = currentElement.previous;
            Element next = currentElement.next;
            prev.next = next;
            next.previous = prev;
            currentElement.previous = last;
            last.next = currentElement;
            last = last.next;
            last.next = null;
        }
    }

    private void addElement(int key) {
        if (first == null) {
            first = new Element(key, null);
            last = first;
        } else {
            last.next = new Element(key, last);
            last = last.next;
        }
        usedCapacity++;
        if (usedCapacity > capacity) {
            removeLRUElement();
            usedCapacity--;
        }
    }

    private void removeLRUElement() {
        int key = first.key;
        if (first.next == null) first = null;
        else {
            first = first.next;
            first.previous = null;
        }
        int index = index(key);
        Node currentNode = table[index];
        while (currentNode.key != key) currentNode = currentNode.next;
        if (currentNode.previous == null) {
            if (currentNode.next == null) table[index] = null;
            else {
                table[index] = currentNode.next;
                table[index].previous = null;
            }
        } else if (currentNode.next == null) currentNode.previous.next = null;
        else {
            Node prev = currentNode.previous;
            Node next = currentNode.next;
            prev.next = next;
            next.previous = prev;
        }
    }

    private int index(int key) {
        int hash = (key) ^ (key >>> 16);
        return hash & (tableSize - 1);
    }
}