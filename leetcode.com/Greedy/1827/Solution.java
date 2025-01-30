class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int sumToIncrease = (nums[i - 1] - nums[i]) + 1;
                count += sumToIncrease;
                nums[i] += sumToIncrease;
            }
        }
        return count;
    }
}