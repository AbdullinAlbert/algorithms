class Solution {

    class Pair {
        int index;
        String value;

        Pair(int index, String value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Pair[] a = new Pair[mat.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            sb.delete(0, sb.length());
            for (int j = 0; j < mat[i].length; j++) sb.append(mat[i][j]);
            String value  = sb.toString();
            a[i] = new Pair(i, value);
        }
        quickSort(a, 0, a.length - 1);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = a[i].index;
        return res;
    }

    private void quickSort(Pair[] a, int start, int end) {
        if (start >= end) return;
        int p = partition(a, start, end);
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    class Comparator {
        int compare(Pair p1, Pair p2) {
            if (p1.value.equals(p2.value)) return p1.index - p2.index;
            int res = 0;
            int i = 0;
            while (i < p1.value.length()) {
                int compare = p1.value.charAt(i) - p2.value.charAt(i);
                if (compare != 0) {
                    res = compare;
                    break;
                }
                i++;
            }
            return res;
        }
    }

    Comparator comparator = new Comparator();

    private int partition(Pair[] a, int start, int end) {
        int p = ((end - start) / 2) + start;

        Pair h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;

        for (int i = start + 1; i <= end; i++) {
            if (comparator.compare(a[i], a[start]) < 0) {
                h = a[less + 1];
                a[less + 1] = a[i];
                a[i] = h;
                less++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return less;
    }
}