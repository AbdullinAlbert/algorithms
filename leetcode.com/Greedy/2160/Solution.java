class Solution {
	
    public int minimumSum(int num) {
        int[] a = new int[4];
        int i = 0;
        while (num > 0) {
            a[i++] = num % 10;
            num /= 10;
        }
        bubbleSort(a);
        return ((a[0] * 10) + a[2]) + (a[1] * 10 + a[3]); 
    }

    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < (a.length - i - 1); j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }
}