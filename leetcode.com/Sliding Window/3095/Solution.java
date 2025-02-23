class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int shortLength = 64;

        for (int i = 0; i < nums.length; i++) {
            int bitwiseSum = 0;
            int tempShortLength = 0;
            for (int j = i; j < nums.length; j++) {
                tempShortLength++;
                bitwiseSum |= nums[j];
                if (bitwiseSum >= k) {
                    shortLength = Math.min(shortLength, tempShortLength);
                    if (shortLength == 1) return 1;
                    break;
                }
            }
        }
        return (shortLength == 64) ? -1 : shortLength;
    }
}