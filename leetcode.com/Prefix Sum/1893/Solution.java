class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] a = new int[52];
        for (int i = 0; i < ranges.length; i++) {
            a[ranges[i][0]]++;
            a[ranges[i][1] + 1]--;
        }
        for (int i = 1; i < a.length; i++) a[i] += a[i - 1];
        while (left <= right) {
            if (a[left] > 0) left++;
            else return false;
        }
        return true;
    }
}