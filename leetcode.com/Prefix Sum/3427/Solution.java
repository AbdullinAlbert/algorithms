class Solution {
    public int subarraySum(int[] nums) {
        int[] ps = new int[nums.length + 1];
        for (int i = 1; i < ps.length; i++) ps[i] = ps[i - 1] + nums[i - 1];
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            int l = max(0, r - nums[r]);
            sum += ps[r + 1] - ps[l];
        }
        return sum;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }
}