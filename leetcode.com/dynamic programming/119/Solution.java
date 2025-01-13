import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int size = rowIndex + 1;
        int[][] a = new int[size][size];
        for (int i = 0; i < size; i++) a[i][0] = 1;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < size; i++) res.add(i, a[rowIndex][i]);
        return res;
    }
}