class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        double res = 0.0;
        for (int i = 0; i < k; i++) sum += nums[i];
        res = sum / k;
        double tempSum = sum;
        for (int i = k; i < nums.length; i++) {
            tempSum += nums[i] - nums[i - k]; 
            if (sum >= tempSum) continue;
            sum = tempSum;
            res = sum / k;
        }
        return res;
    }
}