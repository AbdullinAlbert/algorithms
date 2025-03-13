class Solution1 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] a = new int[102];
        for(int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            a[list.get(0)]++;
            a[list.get(1) + 1]--;
        }
        int count = (a[0] > 0) ? 1 : 0;
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
            if (a[i] > 0) count++;
        }
        return count;
    }
}