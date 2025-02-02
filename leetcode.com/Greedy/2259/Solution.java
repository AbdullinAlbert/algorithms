class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder(number);
        int lastIndexOfTargetDigit = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                if (i == number.length() - 1) {
                    sb.deleteCharAt(i);
                    return sb.toString();
                } else if (number.charAt(i) < number.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    return sb.toString();
                } else lastIndexOfTargetDigit = i;
            }
        }
        return sb.deleteCharAt(lastIndexOfTargetDigit).toString();
    }
}