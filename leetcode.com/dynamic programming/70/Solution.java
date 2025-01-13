class Solution {
    public int climbStairs(int n) {
        int[] a = new int[] { 1, 2, 3 };
        for (int i = 3; i < n; i++) a[i % a.length] = a[(i - 1) % a.length] + a[(i - 2) % a.length];
        return a[(n - 1) % a.length];
    }
}