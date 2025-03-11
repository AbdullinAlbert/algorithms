class Solution {

    class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Borders {
        int left;
        int right;

        Borders(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public int numberOfPoints(List<List<Integer>> nums) {
        Pair[] a = new Pair[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> points = nums.get(i);
            a[i] = new Pair(points.get(0), points.get(1));
        }
        qSort(a, 0, a.length - 1);

        int start = a[0].start;
        int end = a[0].end;

        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].start <= end) {
                if (a[i].end > end)end = a[i].end;
            }
            else {
                count += end - start + 1;
                start = a[i].start;
                end = a[i].end;
            }
        }
        count += end - start + 1;

        return count;
    }

    void qSort(Pair[] a, int start, int end) {
        if (start >= end) return;
        Borders b = partition(a, start, end);
        qSort(a, start, b.left - 1);
        qSort(a, b.right + 1, end);
    }

    Borders partition(Pair[] a, int start, int end) {
        int pivot = ((end - start) / 2) + start;

        Pair h = a[start];
        a[start] = a[pivot];
        a[pivot] = h;

        int less = start;
        int eq = start;

        for (int i = start + 1; i <= end; i++) {
            int compare = compare(a[i], a[start]);
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

    int compare(Pair p1, Pair p2) {
        int res = p1.start - p2.start;
        if (res != 0) return res;
        return p1.end - p2.end;
    }

}