class Solution {
    public int balancedStringSplit(String s) {
        int r = 0;
        int l = 0;
        int count = 0;
        char L = 'L';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == L) l++;
            else r++;
            if (r == l) {
                count++;
                r = 0;
                l = 0;
            }
        }
        return count;
    }
}