import java.util.LinkedList;
import java.util.List;

public class Solution {

    String[] values = new String[] {
        null,
        null,
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    int[] indexes = new int[4];

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        int key = Integer.parseInt(digits.substring(0, 1));
        int firstDigitLength = values[key].length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (indexes[0] < firstDigitLength) {
            int currentCharIndex = i % digits.length();
            key = Integer.parseInt(digits.substring(currentCharIndex, currentCharIndex + 1));
            sb.append(values[key].charAt(indexes[i]));
            i++;
            if (i == digits.length()) {
                res.add(sb.toString());
                sb.delete(0, sb.length());
                int j = i - 1;
                indexes[j]++;
                while (j > 0) {
                    key = Integer.parseInt(digits.substring(j, j + 1));
                    int digitLength = values[key].length();
                    if (indexes[j] == digitLength) {
                        indexes[j] = 0;
                        indexes[j - 1]++;
                    }
                    j--;
                }
                i = 0;
            }
        }
        return res;
    }
}
