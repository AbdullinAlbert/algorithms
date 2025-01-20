class Solution {


    public boolean divisorGame(int n) {
        int[] a = new int[n + 1];
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= (i / 2); j++) {
                if (i % j == 0 && a[j] != -1) {
                    int h = j;
                    int k = i;
                    boolean isAlice = true;
                    while (k > 1 && a[h] != -1) {
                        k = k - a[h];
                        h = k;
                        isAlice = !isAlice;
                    }
                    if (!isAlice) {
                        a[i] = j;
                        break; 
                    }
                }
                if (a[i] == 0) a[i] = -1;
            }
        }
        return (n == 1) ? false : a[n] != -1;
    }
}