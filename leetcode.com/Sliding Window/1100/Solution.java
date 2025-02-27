class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int res = 0;
        if (s.length() < k) return res;
        for (int i = 0; i <= s.length() - k; i++) {
            char[] chars = new char[26];
            boolean unique = true;
            for (int j = i; j < i + k; j++) {
                if (chars[s.charAt(j) % 26] == 0) {
                    chars[s.charAt(j) % 26] = s.charAt(j);
                } else {
                    unique = false;
                    break;
                }
            }
            if (unique) res++;
        }
        return res;
    }
}