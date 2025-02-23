class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int res = Integer.MAX_VALUE;
        for (int s = l; s <= r; s++) {
            for (int i = 0; i <= nums.size() - s; i++) {
                int sum = 0;
                for (int j = i; j < i + s; j++) sum += nums.get(j);
                if (sum > 0 && sum < res) res = sum;
                if (res == 1) return res;
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}