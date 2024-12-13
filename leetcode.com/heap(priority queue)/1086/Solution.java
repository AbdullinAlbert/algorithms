import java.util.Random;

class Solution {

    class List {

        int length = 0;

        Item first = null;
        Item last = null;

        class Item {
            int id;
            int value;

            Item next;

            Item(int id, int value) {
                this.id = id;
                this.value = value;
            }
        }

        void add(int id, int value) {
            Item item = new Item(id, value);
            if (first == null) {
                first = item;
                last = item;
            } else {
                last.next = item;
                last = last.next;
            }
            length++;
        }
    }



    public int[][] highFive(int[][] items) {
        quickSort(items, 0, items.length - 1);
        List list = new List();
        int start = 0;
        while (start < items.length) {
            int end = start;
            while (end < items.length && items[end][0] == items[start][0]) end++;
            end--;
            int length = end - start + 1;
            int sum = 0;
            if (length == 5) {
                for (int j = start; j <= end; j++) sum += items[j][1];
                int average = sum / 5;
                list.add(items[start][0], average);
            } else {
                for (int i = start; i < start + 5; i++) {
                    int middle = (end + i) / 2;
                    for (int j = middle; j >= i; j--) heapify(items, j, middle, end, i);
                }
                for (int i = start; i < start + 5; i++) sum += items[i][1];
                int average = sum / 5;
                list.add(items[start][0], average);
            }
            start = ++end;
        }
        int[][] res = new int[list.length][2];
        int i = 0;
        List.Item currentItem = list.first;
        while (currentItem != null) {
            res[i][0] = currentItem.id;
            res[i][1] = currentItem.value;
            i++;
            currentItem = currentItem.next;
        }
        return res;
    }

    private void heapify(int[][] a, int currentPos, int middle, int end, int shift)  {
        int hp1 = (currentPos << 1) + 1 - shift;
        int hp2 = hp1 + 1;
        if (hp2 <= end) {
            int hp = (a[hp1][1] < a[hp2][1]) ? hp2 : hp1;
            if (a[currentPos][1] < a[hp][1]) {
                int h = a[currentPos][1];
                a[currentPos][1] = a[hp][1];
                a[hp][1] = h;
                if (hp <= middle) heapify(a, hp, middle, end, shift);
            }
        } else if (hp1 <= end && a[currentPos][1] < a[hp1][1]) {
            int h = a[currentPos][1];
            a[currentPos][1] = a[hp1][1];
            a[hp1][1] = h;
        }
    }

    private void quickSort(int[][] a, int start, int end) {
        if (start >= end) return;
        Borders b = partition(a, start, end);
        quickSort(a, start, b.left - 1);
        quickSort(a, b.right + 1, end);
    }

    private final Random r = new Random();

    private class Borders {
        int left;
        int right;

        Borders(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private Borders partition(int[][] a, int start, int end) {
        int p = (end + start) / 2;

        int h = a[start][0];
        a[start][0] = a[p][0];
        a[p][0] = h;

        h = a[start][1];
        a[start][1] = a[p][1];
        a[p][1] = h;


        int less = start;
        int eq = start;

        for (int i = start + 1; i <= end; i++) {
            if (a[i][0] < a[start][0]) {

                h = a[less + 1][0];
                a[less + 1][0] = a[i][0];
                a[i][0] = h;

                h = a[less + 1][1];
                a[less + 1][1] = a[i][1];
                a[i][1] = h;

                if (less < eq) {
                    h = a[eq + 1][0];
                    a[eq + 1][0] = a[i][0];
                    a[i][0] = h;

                    h = a[eq + 1][1];
                    a[eq + 1][1] = a[i][1];
                    a[i][1] = h;
                }

                eq++;
                less++;

            } else if (a[i][0] == a[start][0]) {

                h = a[eq + 1][0];
                a[eq + 1][0] = a[i][0];
                a[i][0] = h;

                h = a[eq + 1][1];
                a[eq + 1][1] = a[i][1];
                a[i][1] = h;

                eq++;
            }
        }

        h = a[start][0];
        a[start][0] = a[less][0];
        a[less][0] = h;

        h = a[start][1];
        a[start][1] = a[less][1];
        a[less][1] = h;

        return new Borders(less, eq);
    }
}