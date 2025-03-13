class Solution {
    public int maximumPopulation(int[][] logs) {
        int range = 1950;
        int[] a = new int[101];
        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0];
            int death = logs[i][1];
            a[birth - range]++;
            a[death - range]--;
        }
        int maxIndex = 0;
        int maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
            if (a[i] > maxSum) {
                maxSum = a[i];
                maxIndex = i;
            }
        }
        return range + maxIndex;
    }
}