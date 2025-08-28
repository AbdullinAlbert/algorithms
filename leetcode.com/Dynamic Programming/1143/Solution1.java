class Solution1 {

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        dp = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) dp[i][j] = -1;
        }
        dp(text1, text2, text2.length(), text1.length());
        return dp[n - 1][m - 1];
    }

    int dp(String text1, String text2, int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];
        if (text1.charAt(j - 1) == text2.charAt(i - 1)) {
            int res = 1 + dp(text1, text2, i - 1, j - 1);
            dp[i][j] = res;
            return res;
        } else {
            int max1 = dp(text1, text2, i - 1, j);
            int max2 = dp(text1, text2, i - 1, j - 1);
            int max3 = dp (text1, text2, i, j - 1);
            int res = max(max1, max2, max3);
            dp[i][j] = res;
            return res;
        }
    }

    int max(int a, int b, int c) {
        int tm = (a > b) ? a : b;
        return (tm > c) ? tm : c;
    }

}