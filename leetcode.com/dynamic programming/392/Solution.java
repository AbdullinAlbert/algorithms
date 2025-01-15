class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean res = true;
        int sPos = 0;
        int tPos = 0;
        while (res && sPos < s.length()) {
            char charToFind = s.charAt(sPos);
            res = false;
            for (int i = tPos; i < t.length(); i++) {
                if (t.charAt(i) == charToFind) {
                    res = true;
                    sPos++;
                    tPos = i + 1;
                    break;
                }
            }
        }
        return res;
    }
}