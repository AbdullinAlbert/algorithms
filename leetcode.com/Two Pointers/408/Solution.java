class Solution {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            } else if (isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false;
                int sum = 0;
                while (j < abbr.length() && isDigit(abbr.charAt(j))) {
                    sum = (sum * 10) + (abbr.charAt(j) - '0');
                    j++;
                }
                i += sum;
            } else return false;
        }
        return (i == word.length() && j == abbr.length()) ? true : false;
    }

    boolean isDigit(char c) {
        return (c >= '0') && (c <= '9');
    }
	
}