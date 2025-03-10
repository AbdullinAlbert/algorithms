class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        for (int i = 1; i < leftSum.length; i++) leftSum[i] = leftSum[i - 1] + nums[i - 1];
        int[] rightSum = new int[nums.length];
        for (int i = rightSum.length - 2; i > -1; i--) rightSum[i] = rightSum[i + 1] + nums[i + 1];
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) res[i] = abs(leftSum[i] - rightSum[i]);
        return res;
    }

    int abs(int a) {
        return (a >= 0) ? a : (a * -1); 
    }
}