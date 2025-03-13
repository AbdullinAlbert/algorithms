class Solution {
    public int pivotIndex(int[] nums) {
        int[] ps = new int[nums.length + 2];
        for (int i = 1; i < ps.length - 1; i++) ps[i] = ps[i - 1] + nums[i - 1];
        ps[ps.length - 1] = ps[ps.length - 2];
        for (int i = 1; i < ps.length - 1; i++) {
            if (ps[ps.length -1] - ps[i] == ps[i - 1]) return i - 1;
        }
        return -1;
    }
}