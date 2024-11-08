import java.util.Random;

class KthLargest {


    DoubleLinkedList list;

    DoubleLinkedList.Element currentRes = null;

    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        quickSort(nums, 0, nums.length - 1);
        list = new DoubleLinkedList(nums, k);
    }

    class DoubleLinkedList {

        Element tail = null;

        class Element {
            Element previous = null;
            Element next = null;

            int data;

            Element(int data) {
                this.data = data;
            }

        }

        DoubleLinkedList(int[] a, int k) {
            int first = (a.length > k) ? (a.length - k) : 0;
            for (int i = first; i < a.length; i++) {
                Element e = new Element(a[i]);
                if (first != 0 && currentRes == null) currentRes = e;
                if (tail == null) tail = e;
                else {
                    tail.next = e;
                    e.previous = tail;
                    tail = e;
                }
            }
        }

        private void add(int data) {
            Element newElement = new Element(data);
            if (tail == null) tail = newElement;
            else if (tail.data <= data) {
                tail.next = newElement;
                newElement.previous = tail;
                tail = newElement;
            } else {
                Element currentEl = tail;
                while (currentEl.previous != null && currentEl.data > data) currentEl = currentEl.previous;
                if (currentEl.previous == null) {
                    if (currentEl.data < data) {
                        newElement.next = currentEl.next;
                        currentEl.next.previous = newElement;

                        newElement.previous = currentEl;
                        currentEl.next = newElement;
                    } else {
                        newElement.next = currentEl;
                        currentEl.previous = newElement;
                    }
                } else {
                    newElement.next = currentEl.next;
                    currentEl.next.previous = newElement;

                    newElement.previous = currentEl;
                    currentEl.next = newElement;
                }
            }
        }
    }

    public int add(int val) {
        if (currentRes == null) {
            list.add(val);
            DoubleLinkedList.Element he = list.tail;
            int currentK = 1;
            while (currentK < k) {
                he = he.previous;
                currentK++;
            }
            currentRes = he;
            return currentRes.data;
        } else if (currentRes.data < val) {
            list.add(val);
            currentRes = currentRes.next;
            return currentRes.data;
        }
        return currentRes.data;
    }

    private class Borders {
        int left;
        int right;

        Borders(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        Borders b = partition(a, start, end);
        quickSort(a, start, b.left - 1);
        quickSort(a, b.right + 1, end);
    }

    private final Random r = new Random();

    private Borders partition(int[] a, int start, int end) {
        int p = r.nextInt(end - start) + start;

        int h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;
        int eq = start;

        for (int j = start + 1;  j <= end; j++) {
            if (a[j] < a[start]) {
                h = a[less + 1];
                a[less + 1] = a[j];
                a[j] = h;

                if (eq > less) {
                    h = a[eq + 1];
                    a[eq + 1] = a[j];
                    a[j] = h;
                }

                less++;
                eq++;
            } else if (a[j] == a[start]) {
                h = a[eq + 1];
                a[eq + 1] = a[j];
                a[j] = h;
                eq++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return new Borders(less, eq);
    }

}