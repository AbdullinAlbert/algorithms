class Solution {
    public int countValidSelections(int[] nums) {
        int[] ps = new int[nums.length + 2];
        for (int i = 1; i < ps.length - 1; i++) ps[i] = ps[i - 1] + nums[i - 1];
        ps[ps.length - 1] = ps[ps.length - 2];
        int count = 0;
        for (int i = 1; i < ps.length - 1; i++) {
            if (nums[i - 1] != 0) continue;
            int diff1 = ps[ps.length - 1] - ps[i];
            int diff2 = abs(ps[i - 1] - diff1);
            if (diff2 == 0) count += 2;
            else if (diff2 == 1) count++;
        }
        return count;
    }

    int abs(int a) {
        return (a >= 0) ? a : (a * -1);
    }
}