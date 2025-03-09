class Solution {
    public int largestAltitude(int[] gain) {
        int[] ps = new int[gain.length + 1];
        int res = ps[0];
        for (int i = 1; i < ps.length; i++) {
            ps[i] = ps[i - 1] + gain[i - 1];
            if (ps[i] > res) res = ps[i];
        }
        return res;
    }
}