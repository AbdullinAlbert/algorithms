class Solution {

    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < (s.length() / 2); i++) {
            int start = i;
            int end = s.length() - 1 - start;
            if (s.charAt(start) != s.charAt(end)) {
                if (s.charAt(start) < s.charAt(end)) sb.setCharAt(end, s.charAt(start));
                else sb.setCharAt(start, s.charAt(end));
            }
        }
        return sb.toString();
    }
	
}