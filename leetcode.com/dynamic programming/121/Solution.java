class Solution {
    public int maxProfit(int[] prices) {
        int minValue = 100_000;
        int res = 0;
        int max = 0;
        int min = minValue;
        for (int i = 0; i < prices.length - 1; i++) {
            boolean notInit = (min == minValue) && (max == 0);
            if (notInit) {
                if (prices[i] < prices[i + 1]) {
                    res = prices[i + 1] - prices[i];
                    min = prices[i];
                    max = prices[i + 1];
                }
            } else if (prices[i + 1] > max && prices[i + 1] > min) {
                max = prices[i + 1];
                int diff = max - min;
                if (diff > res) res = diff;
            } else if (prices[i + 1] < min) {
                min = prices[i + 1];
                max = 0;
            }
        }
        return res;
    }
}