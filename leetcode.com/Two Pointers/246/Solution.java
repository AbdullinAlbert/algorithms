class Solution {
    
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            int abs = abs(num.charAt(i), num.charAt(j));
            boolean a = (abs == 3 && isSixNine(num.charAt(i), num.charAt(j)));
            boolean b = (abs == 0 && isSymmetric(num.charAt(i)));
            if (a || b) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    boolean isSixNine(char c1, char c2) {
        return (c1 == '6' && c2 == '9') || (c1 == '9' && c2 == '6');
    }

    boolean isSymmetric(char c) {
        return c == '0' || c == '8' || c == '1';
    }

    private int abs(char c1, char c2) {
        int res = c1 - c2;
        return (res >= 0) ? res : res * (-1);
    }

}