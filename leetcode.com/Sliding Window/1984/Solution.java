class Solution {
    public int minimumDifference(int[] nums, int k) {
        qSort(nums, 0, nums.length - 1);
        int start = 0;
        int end = k - 1;

        int minDiff = Integer.MAX_VALUE;

        while (end < nums.length) {
            int currentDiff = nums[end++] - nums[start++];
            if (currentDiff < minDiff) minDiff = currentDiff;
        }

        return minDiff;
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
        Borders borders = partition(a, start, end);
        qSort(a, start, borders.left - 1);
        qSort(a, borders.right + 1, end);
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