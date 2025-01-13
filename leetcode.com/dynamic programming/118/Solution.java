import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] a = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) a[i][0] = 1;
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> firstRow = new LinkedList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new LinkedList<>();
            currentRow.add(1);
            for (int j = 1; j <= i; j++) {
                a[i][j] = a[i-1][j-1] + a[i-1][j];
                currentRow.add(a[i][j]);
            }
            res.add(currentRow);
        }
        return res;
    }
}