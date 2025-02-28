class Solution {

    public int[] distinctNumbers(int[] nums, int k) {
        int size = nums.length - k + 1;
        int[] res = new int[size];
        int setLength = 100_000;
        int[] n = new int[setLength];
        int uniqueCount = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {
            index = nums[i] % setLength;
            n[index]++;
            if (n[index] == 1) uniqueCount++;
        }
        res[0] = uniqueCount;
        int start = 1;
        int end = k;
        while (end < nums.length) {
            index = nums[start - 1] % setLength;
            n[index]--;
            if (n[index] == 0 && uniqueCount > 1) uniqueCount--;
            index = nums[end] % setLength;
            n[index]++;
            if (n[index] == 1 && uniqueCount < k) uniqueCount++;
            res[start++] = uniqueCount;
            end++;
        }
        return res;
    }
}