class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        qSort(nums, 0, nums.length - 1);
        int[] ps = new int[nums.length + 1];
        for (int i = 1; i < ps.length; i++) ps[i] = ps[i - 1] + nums[i - 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = findIndex(ps, 0, ps.length - 1, queries[i], 0);
            if (ps[index] > queries[i]) index--;
            res[i] = index;
        }
        return res;
    }

    int findIndex(int[] a, int start, int end, int value, int currentIndex) {
        if (start > end) return currentIndex;
        int m = ((end - start) / 2) + start;
        if (a[m] == value) return m;
        if (a[m] > value) return findIndex(a, start, m - 1, value, m);
        else return findIndex(a, m + 1, end, value, m);
    }

    class Borders {
        int left;
        int right;

        Borders(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    void qSort(int[] a, int start, int end) {
        if (start >= end) return;
        Borders b = partition(a, start, end);
        qSort(a, start, b.left - 1);
        qSort(a, b.right + 1, end);
    }

    Borders partition(int[] a, int start, int end) {
        int pivot = ((end - start) / 2) + start;

        int h = a[start];
        a[start] = a[pivot];
        a[pivot] = h;

        int less = start;
        int eq = start;

        for (int i = start + 1; i <= end; i++) {
            if (a[i] < a[start]) {
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
            } else if (a[i] == a[start]) {
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
}