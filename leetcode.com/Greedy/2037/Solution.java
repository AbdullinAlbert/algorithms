class Solution {

    class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        quickSort(seats, 0, seats.length - 1);
        quickSort(students, 0, students.length - 1);
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            count += abs(seats[i] - students[i]);
        }
        return count;
    }

    private int abs(int n) {
        return (n >= 0) ? n : n * (-1);
    }

    private void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        Pair p = partition(a, start, end);
        quickSort(a, start, p.left - 1);
        quickSort(a, p.right + 1, end);
    }

    private Pair partition(int[] a, int start, int end) {
        int p = ((end - start) / 2) + start;
        
        int h = a[start];
        a[start] = a[p];
        a[p] = h;

        int min = start;
        int eq = start;

        for (int i = start + 1; i <= end; i++) {
            if (a[i] < a[start]) {
                h = a[min + 1];
                a[min + 1] = a[i];
                a[i] = h;
                if (eq > min) {
                    h = a[eq + 1];
                    a[eq + 1] = a[i];
                    a[i] = h;
                }
                eq++;
                min++;
            } else if (a[i] == a[start]) {
                h = a[eq + 1];
                a[eq + 1] = a[i];
                a[i] = h;
                eq++;
            }
        }

        h = a[start];
        a[start] = a[min];
        a[min] = h;

        return new Pair(min, eq);
    }
}