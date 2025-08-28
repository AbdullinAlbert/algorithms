class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        int[][] dp = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(j - 1) == text2.charAt(i - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n - 1][m - 1];
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }
}