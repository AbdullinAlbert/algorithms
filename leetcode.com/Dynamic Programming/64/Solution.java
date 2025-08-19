class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] minSum = new int[n][m];
        minSum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) minSum[0][i] = minSum[0][i - 1] + grid[0][i];
        for (int i = 1; i < n; i++) minSum[i][0] = minSum[i - 1][0] + grid[i][0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                minSum[i][j] = grid[i][j] + min(minSum[i - 1][j], minSum[i][j - 1]);
            }
        }
        return minSum[n - 1][m - 1];
    }

    int min(int a, int b) {
        return (a < b) ? a : b;
    }

}