class Solution {
    public int maximum69Number (int num) {
        int firstSix = -1;
        int h = num;
        int count = 0;
        while (h > 0) {
            int n = h % 10;
            h = h / 10;
            if (n == 6) firstSix = count;
            count++;
        }
        if (firstSix == -1) return num;
        int add = 3;
        for(int i = 1; i <= firstSix; i++) {
            add *= 10;
        }
        return num + add;
    }
}