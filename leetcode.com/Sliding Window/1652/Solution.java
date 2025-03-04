class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] helperCode = new int[code.length];
        if (k == 0) return helperCode;
        for (int i = 0; i < code.length; i++) helperCode[i] = code[i];
        int absK = (k > 0) ? k : (k * -1);
        for (int i = 0; i < code.length; i++) {
            int count = 0;
            int sum = 0;
            if (k < 0) {
                int j = i - 1;
                while (count < absK) {
                    int index = (j < 0) ? (code.length + j) : j;
                    sum += helperCode[index];
                    j--;
                    count++;
                }
            } else {
                int j = i + 1;
                while (count < absK) {
                    sum += helperCode[j % code.length];
                    j++;
                    count++;
                }
            }
            code[i] = sum;
        }
        return code;
    }
}