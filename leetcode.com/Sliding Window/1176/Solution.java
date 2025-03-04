class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) sum += calories[i];
        if (sum < lower) res--;
        else if (sum > upper) res++;
        int start = 1;
        int end = k;
        while (end < calories.length) {
            sum += calories[end] - calories[start - 1];
            if (sum < lower) res--;
            else if (sum > upper) res++;
            end++;
            start++;
        }
        return res;
    }
}