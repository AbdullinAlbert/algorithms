class Solution {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder(time);
        for (int i = 0; i < time.length(); i++) {
            if (sb.charAt(i) == '?') {
                if (i == 0) {
                    if (sb.charAt(1) > '3' && sb.charAt(1) != '?') sb.setCharAt(i, '1');
                    else sb.setCharAt(i, '2');                 
                }
                else if (i == 1) {
                    if (sb.charAt(0) == '0' || sb.charAt(0) == '1') sb.setCharAt(i, '9');
                    else sb.setCharAt(i, '3');
                } else if (i == 3) sb.setCharAt(i, '5');
                else sb.setCharAt(i, '9');
            }
        }
        return sb.toString();
    }
}