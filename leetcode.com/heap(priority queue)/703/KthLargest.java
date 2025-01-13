package untitled;

class KthLargest {

    int[] a;

    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        int max = Math.max(k, nums.length);
        a = new int[max + 1];
        for (int i = 0; i < nums.length; i++) a[i + 1] = nums[i];
        if (nums.length < k) a[k] = Integer.MIN_VALUE;
        quickSort(a, 1, a.length - 1);
        int i = 1;
        int j = a.length - 1;
        while (i < j) {
            int h = a[i];
            a[i] = a[j];
            a[j] = h;
            i++;
            j--;
        }
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

    private Borders partition(int[] a, int start, int end) {
        int p = ((end - start) / 2) + start;

        int h = a[start];
        a[start] = a[p];
        a[p] = h;

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

    public int add(int val) {
        if (a[a.length - 1] >= val) return a[k];
        a[a.length - 1] = val;
        int p = a.length - 1;
        while (p > 1 && a[p] > a[p - 1]) {
            int h = a[p - 1];
            a[p - 1] = a[p];
            a[p] = h;
            p--;
        }
        return a[k];
    }

}