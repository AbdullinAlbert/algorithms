class Solution {

    class Node {
        Node next;
        Pair value;

        Node(Pair value) {
            this.value = value;
        }
    }

    class Pair {
        int num;
        int count;

        Pair(int num) {
            this.num = num;
            count = 1;
        }

    }

    int tableSize = 8192;

    Node[] table = new Node[tableSize];

    boolean add(int num) {
        int index = index(num);
        if (table[index] == null) {
            table[index] = new Node(new Pair(num));
            return true;
        }
        Node currentNode = table[index];
        while(currentNode.next != null) {
            if (currentNode.value.num == num) {
                currentNode.value.count++;
                return false;
            }
            currentNode = currentNode.next;
        }
        if (currentNode.value.num == num) {
            currentNode.value.count++;
            return false;
        }
        currentNode.next = new Node(new Pair(num));
        return true;
    }

    int index(int num) {
        int hash = (num >>> 16) ^ num;
        return hash & (tableSize - 1);
    }

    public int findLHS(int[] nums) {
        
        int realSize = 0;

        for (int i = 0; i < nums.length; i++) {
            if (add(nums[i])) realSize++;
        }

        Pair[] a = new Pair[realSize];

        int j = 0;
        for (int i = 0; i < table.length; i++) {
            Node currentNode = table[i];
            while (currentNode != null) {
                a[j++] = currentNode.value;
                currentNode = currentNode.next;
            }
        }

        qSort(a, 0, a.length - 1);

        int maxLength = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i].num - a[i-1].num == 1) {
                int currentLength = a[i].count + a[i-1].count;
                if (currentLength > maxLength) maxLength = currentLength;
            } 
        }

        return maxLength;
    }

    int abs(int a) {
        return (a >= 0) ? a : (a * -1);
    }

    void qSort(Pair[] nums, int start, int end) {
        if (start >= end) return;
        Borders bordrers = partition(nums, start, end);
        qSort(nums, start, bordrers.left - 1);
        qSort(nums, bordrers.right + 1, end);
    }


    Borders partition(Pair a[], int start, int end) {
        int pivot = ((end - start) / 2) + start;

        Pair h = a[start];
        a[start] = a[pivot];
        a[pivot] = h;

        int less = start;
        int eq = start;

        for (int i = start + 1; i <= end; i++) {
            int compare = a[i].num - a[start].num;
            if (compare < 0) {
                h = a[less + 1];
                a[less + 1] = a[i];
                a[i] = h;

                if (less < eq) {
                    h = a[eq + 1];
                    a[eq + 1] = a[i];
                    a[i] = h;
                }

                less++;
                eq++;
            } else if (compare == 0) {

                h = a[eq + 1];
                a[eq + 1] = a[i];
                a[i] = h;

                eq++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return new Borders(less, eq);
    }

    class Borders {
        int left;
        int right;

        Borders(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}