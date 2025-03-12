class NumArray {

    int[] ps;

    public NumArray(int[] nums) {
        ps = new int[nums.length + 1];
        for (int i = 1; i < ps.length; i++) ps[i] = ps[i - 1] + nums[i - 1];
    }
    
    public int sumRange(int left, int right) {
        return ps[right + 1] - ps[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */