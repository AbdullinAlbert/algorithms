class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ml = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int hl = 1;
                int j = i + 1;
                while ((j < nums.length) && (nums[j] <= threshold) && (nums[j] % 2 != nums[j - 1] % 2)) {
                    hl++;
                    j++;
                }
                if (hl > ml) ml = hl;
                i = j;
            } else i++;
        }
        return ml;
    }
}