class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isDigit(s.charAt(i))) sb.append(s.charAt(i));
            if (isLetter(s.charAt(i))) sb.append(Character.toLowerCase(s.charAt(i)));
        }
        String newS = sb.toString();
        int i = 0;
        int j = newS.length() - 1;
        while (i < j) {
            if (newS.charAt(i) != newS.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isDigit(char c) {
        return (('0' <= c) && (c <= '9'));
    }

    private boolean isLetter(char c) {
        return (('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z'));
    }
}