class Solution {

    class DisjointSet {
        private final int[] rank;
        private final int[] root;

        DisjointSet(int size) {
            rank = new int[size];
            root = new int[size];
            for (int i = 0; i < size; i++) {
                rank[i] = 1;
                root[i] = i;
            }
        }

        private int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) root[rootY] = rootX;
                else if (rank[rootX] < rank[rootY]) root[rootX] = rootY;
                else {
                    root[rootY] = rootX;
                    rank[rootX]++; 
                }
            }
        }

        int size() {
            boolean[] provincesCount = new boolean[root.length];
            int size = 0;
            for (int i = 0; i < root.length; i++) {
                int rootI = find(i);
                if (!provincesCount[rootI]) {
                    provincesCount[rootI] = true;
                    size++;
                }
            }
            return size;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        DisjointSet ds = new DisjointSet(isConnected[0].length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (i != j && isConnected[i][j] == 1) ds.union(i, j);
            }
        }
        return ds.size();
    }
}