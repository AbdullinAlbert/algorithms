class Solution {
    public int pivotInteger(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i < a.length; i++) a[i] = a[i -  1] + i;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] + a[i - 1] == a[a.length - 1]) return i;
        }
        return -1;
    }
}