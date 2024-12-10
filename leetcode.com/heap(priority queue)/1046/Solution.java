public class Solution {
    public int lastStoneWeight(int[] stones) {
        int length = stones.length;
        int[] ha = new int[length + 1];
        for (int i = 0, j = 1; i < stones.length; i++, j++) ha[j] = stones[i];

        while (length > 1) {

            for (int i = 1; i < 3; i++) {
                int middle = (length + i) / 2;
                int shift = i - 1;
                for (int currentPos = middle; currentPos >= i; currentPos--) push(ha, currentPos, shift, middle, length);
            }

            ha[1] -= ha[2];
            ha[2] = 0;
            if (ha[1] == 0) {
                ha[1] = ha[length];
                ha[length] = 0;
                ha[2] = ha[length - 1];
                ha[length - 1] = 0;
                length -= 2;
            } else {
                ha[2] = ha[length];
                ha[length] = 0;
                length--;
            }
        }
        return (length == 0) ? 0 : ha[1];
    }

    private void push(int[] a, int currentPos, int shift, int middle, int length) {
        int hp1 = currentPos * 2 - shift;
        int hp2 = hp1 + 1;
        if (hp2 <= length) {
            int hp = (a[hp1] < a[hp2]) ? hp2 : hp1;
            if (a[currentPos] < a[hp]) {
                int h = a[currentPos];
                a[currentPos] = a[hp];
                a[hp] = h;
                if (hp < middle) push(a, hp, shift, middle, length);
            }
        } else if (hp1 <= length && a[currentPos] < a[hp1]) {
            int h = a[currentPos];
            a[currentPos] = a[hp1];
            a[hp1] = h;
        }
    }
}
