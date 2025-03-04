class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        int size = 26;
        int[] a = new int[size];
        int res = 0;
        int uniqueCount = 0;
        for (int i = 0; i < 3; i++) {
            int index = s.charAt(i) % size;
            a[index]++;
            if (a[index] == 1) uniqueCount++;
        }
        if (uniqueCount == 3) res++;
        int start = 1;
        int end = 3;
        while (end < s.length()) {
            int index = s.charAt(start - 1) % size;
            a[index]--;
            if (a[index] == 0) uniqueCount--;
            index = s.charAt(end) % size;
            a[index]++;
            if (a[index] == 1) uniqueCount++;
            if (uniqueCount == 3) res++;
            start++;
            end++;
        }
        return res;
    }
}