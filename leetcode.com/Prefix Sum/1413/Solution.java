class Solution {
    public int minStartValue(int[] nums) {
        int min = 100;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (min > sum) min = sum;
        }
        if (min > -1) return 1;
        min *= -1;
        return min + 1;
    }
}