class Solution {

    static class DisjointSet {
        int[] root;
        int[] size;
        int[] timeStamp;
        int rootsCount;
        int lts;

        DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            timeStamp = new int[n];
            rootsCount = n;
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
                timeStamp[i] = -1;
            }
        }

        int rootOf(int x) {
            if (x == root[x]) return x;
            return root[x] = rootOf(root[x]);
        }

        void union(int ts, int x, int y) {
            int rootX = rootOf(x);
            int rootY = rootOf(y);
            if (rootX != rootY) {
                rootsCount--;
                lts = lastTimeStamp(timeStamp[rootX], timeStamp[rootY], ts);
                if (size[rootX] > size[rootY]) {
                    root[rootY] = rootX;
                    size[rootX] += size[rootY];
                    timeStamp[rootX] = lts;
                    timeStamp[rootY] = -1; 
                } else {
                    root[rootX] = rootY;
                    size[rootY] += size[rootX];
                    timeStamp[rootY] = lts;
                    timeStamp[rootX] = -1; 
                }
            }
        }

        int lastTimeStamp(int a, int b, int c) {
            int h1 = (a > b) ? a : b;
            return (h1 > c) ? h1 : c;
        }

        int earliestTimestamp() {
            return (rootsCount > 1) ? - 1 : lts;
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        quickSort(logs, 0, logs.length - 1);
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < logs.length; i++) {
            ds.union(logs[i][0], logs[i][1], logs[i][2]);
        }
        return ds.earliestTimestamp();
    }

    private void quickSort(int[][] a, int start, int end) {
        if (start >= end) return;
        int pivot = partition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    private int partition(int[][] a, int start, int end) {
        int pivot = start + (end - start) / 2;

        int hts = a[start][0];
        int hx = a[start][1];
        int hy = a[start][2];

        a[start][0] = a[pivot][0];
        a[start][1] = a[pivot][1];
        a[start][2] = a[pivot][2];

        a[pivot][0] = hts;
        a[pivot][1] = hx;
        a[pivot][2] = hy;

        int less = start;
        for (int i = start + 1; i <= end; i++) {
            if (a[i][0] < a[start][0]) {

                hts = a[less + 1][0];
                hx = a[less + 1][1];
                hy = a[less + 1][2];

                a[less + 1][0] = a[i][0];
                a[less + 1][1] = a[i][1];
                a[less + 1][2] = a[i][2];

                a[i][0] = hts;
                a[i][1] = hx;
                a[i][2] = hy;

                less++;
            }
        }

        hts = a[start][0];
        hx = a[start][1];
        hy = a[start][2];

        a[start][0] = a[less][0];
        a[start][1] = a[less][1];
        a[start][2] = a[less][2];

        a[less][0] = hts;
        a[less][1] = hx;
        a[less][2] = hy;

        return less;
    }
}