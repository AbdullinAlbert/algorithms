/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {

    class Stack {

        Node last;

        class Node {
            Node previous;

            ImmutableListNode data;

            Node(Node previous, ImmutableListNode data) {
                this.previous = previous;
                this.data = data;
            }
        }

        void put(ImmutableListNode data) {
            if (last == null) last = new Node(null, data);
            else {
                Node newNode = new Node(last, data);
                last = newNode;
            }
        }

        ImmutableListNode pop() {
            if (last == null) return null;
            Node previousNode = last.previous;
            ImmutableListNode data = last.data;
            last = previousNode;
            return data;
        } 
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack stack = new Stack();
        stack.put(head);
        ImmutableListNode next = head.getNext();
        while (next != null) {
            stack.put(next);
            next = next.getNext();
        }
        ImmutableListNode node;
        while ((node = stack.pop()) != null) node.printValue();
    }
}