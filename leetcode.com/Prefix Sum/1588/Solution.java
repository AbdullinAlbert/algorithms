class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] ps = new int[arr.length + 1];
        for (int i = 1; i < ps.length; i++) ps[i] = ps[i - 1] + arr[i - 1];
        int res = ps[ps.length - 1];
        int step = 3;
        while (step < ps.length) {
            for (int i = step; i < ps.length; i++) res += ps[i] - ps[i - step];
            step += 2;
        }
        return res;
    }
}