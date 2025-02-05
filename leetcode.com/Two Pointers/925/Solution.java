class Solution {
	
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) return false;
            int nCount = sameLettersCount(i, name);
            int tCount = sameLettersCount(j, typed);
            if (nCount > tCount) return false;
            i += nCount;
            j += tCount;
        }
        return (i == name.length() && j == typed.length());
    }

    int sameLettersCount(int i, String s) {
        int h = i + 1;
        int count = 1;
        while (h < s.length() && s.charAt(i) == s.charAt(h)) {
            h++;
            count++;
        }
        return count;
    } 

}