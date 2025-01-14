class Solution {
    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        int cp = 1;
        int np = cp << 1;
        for (int i = 1; i <= n; i++) {
            if (i == np) {
                cp = np;
                np = cp << 1;
            }
            a[i] = a[i - cp] + 1;
        }
        return a;
    }
}