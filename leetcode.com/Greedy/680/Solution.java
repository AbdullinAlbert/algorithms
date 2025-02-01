class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int left = 0;
        int right = 0;
        int deleteCount = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                left = i;
                right = j;
                break;
            }
            i++;
            j--;
        }
        if (left == right) return true;
        
        String newS = new StringBuilder(s).deleteCharAt(left).toString();
        boolean res = isPalindrome(newS);
        if (res) return true;

        newS = new StringBuilder(s).deleteCharAt(right).toString();
        return isPalindrome(newS);
    }

    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}