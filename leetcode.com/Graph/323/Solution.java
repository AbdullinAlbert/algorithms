class Solution {

    static class DisjointSet {
        private final int[] root;
        private final int[] size;
        private int count = 0;
        
        DisjointSet(int length) {
            root = new int[length];
            size = new int[length];
            count = length;
            for (int i = 0; i < length; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        private int rootOf(int x) {
            if (x == root[x]) return x;
            return root[x] = rootOf(root[x]);
        }

        void union(int x, int y) {
            int rootX = rootOf(x);
            int rootY = rootOf(y);
            if (rootX != rootY) {
                if (size[rootX] > size[rootY]) {
                    root[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else {
                    root[rootX] = rootY;
                    size[rootY] += size[rootX];
                }
                count--;
            }
        }

        int count() {
            return count;
        }
    }

    public int countComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < edges.length; i++) ds.union(edges[i][0], edges[i][1]);
        return ds.count();
    }
}