class Solution {
    public int longestPalindromeSubseq(String s) {
        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) dp[i][i] = 1;
        int step = 1;
        while (step < l) {
            int i = 0;
            int j = i + step;
            while (j < l) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i + 1][j - 1];
                else {
                    int m1 = dp[i][j - 1];
                    int m2 = dp[i + 1][j];
                    dp[i][j] = (m1 > m2) ? m1 : m2;
                }
                i++;
                j = i + step;
            }
            step++;
        }
        return dp[0][l - 1];
    }
}