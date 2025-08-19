class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) nums[i] += nums[0];
            else nums[i] += max(nums[i - 2], nums[i - 3]);
        }
        return max(nums[nums.length - 1], nums[nums.length - 2]);
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }
}