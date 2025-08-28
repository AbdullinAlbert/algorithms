class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) dp[0][i] = i;
        for (int i = 0; i < n; i++) dp[i][0] = i;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }

    int min(int a, int b) {
        return (a < b) ? a : b;
    }
}