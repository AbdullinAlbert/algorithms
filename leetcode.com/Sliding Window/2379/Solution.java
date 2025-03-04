class Solution {
    public int minimumRecolors(String blocks, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) if (blocks.charAt(i) == 'B') maxSum++;
        int start = 1;
        int end = k;
        int currentSum = maxSum;
        while (end < blocks.length()) {
            if (blocks.charAt(start - 1) == 'B') currentSum--;
            if (blocks.charAt(end) == 'B') currentSum++;
            if (currentSum > maxSum) maxSum = currentSum;
            start++;
            end++;
        }
        return k - maxSum;
    }
}