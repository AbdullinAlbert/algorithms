class Solution {
    public int fib(int n) {
        int[] f = new int[] { 0, 1, 1 };
        for (int i = 3; i <= n; i++) {
            f[i % f.length] = f[(i - 1) % f.length] + f[(i - 2) % f.length];
        }
        return f[n % f.length];
    }
}