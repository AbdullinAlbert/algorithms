class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int res = 0;
        if (s.length() < k) return res;
        int size = 26;
        char[] charsCount = new char[size];
        int uniqueCount = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {
            index = s.charAt(i) % size;
            charsCount[index]++;
            if (charsCount[index] == 1) uniqueCount++; 
        }
        if (uniqueCount == k) res++;
        int start = 1;
        int end = k;
        while (end < s.length()) {
            index = s.charAt(start - 1) % size;
            charsCount[index]--;
            if (charsCount[index] == 0 && uniqueCount > 1) uniqueCount--;
            index = s.charAt(end) % size;
            charsCount[index]++;
            if (charsCount[index] == 1 && uniqueCount < k) uniqueCount++;
            if (uniqueCount == k) res++;
            start++;
            end++;
        }
        return res;
    }
}