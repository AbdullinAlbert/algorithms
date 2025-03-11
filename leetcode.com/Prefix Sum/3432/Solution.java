class Solution {
    public int countPartitions(int[] nums) {
        int[] ps = new int[nums.length + 1];
        for (int i = 1; i < ps.length; i++) ps[i] = ps[i - 1] + nums[i - 1];
        int count = 0;
        for (int i = 1; i < ps.length - 1; i++) {
            int diff = (ps[i] << 1) - ps[ps.length - 1];
            if (diff % 2 == 0) count++;
        }
        return count;
    }
}