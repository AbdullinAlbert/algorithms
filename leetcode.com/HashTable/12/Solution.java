public class Solution {

    class Pair {
        String symbol;
        int value;

        Pair(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }

    Pair[] table = new Pair[] {
        new Pair("I", 1),
        new Pair("V", 5),
        new Pair("X", 10),
        new Pair("L", 50),
        new Pair("C", 100),
        new Pair("D", 500),
        new Pair("M", 1000)
    };

    public String intToRoman(int num) {
        int length = 4;
        int[] a = new int[length];
        int i = 0;
        while (num != 0) {
            int powerOfTen = getPowerOfTen(i + 1);
            int res = num % powerOfTen;
            a[i] = res;
            num -= res;
            i++;
        }
        StringBuilder res = new StringBuilder();
        for (i = a.length - 1; i >= 0; i--) {
            if (a[i] == 0) continue;
            int highDigit = Integer.parseInt(Integer.toString(a[i]).substring(0, 1));
            if (highDigit == 4 || highDigit == 9) res.append(subtractiveForm(a[i]));
            else res.append(getRomanValue(a[i]));
        }
        return res.toString();
    }

    private String subtractiveForm(int decimalValue) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (table[i].value < decimalValue) i++;
        res.append(table[i].symbol);
        int dif = table[i].value - decimalValue;
        int j = 0;
        while (table[j].value != dif) j++;
        res.insert(0, table[j].symbol);
        return res.toString();
    }

    private String getRomanValue(int decimalValue) {
        StringBuilder res = new StringBuilder();
        int i = table.length - 1;
        while (decimalValue != 0) {
            if (decimalValue % table[i].value == decimalValue) i--;
            else if (decimalValue % table[i].value == 0) {
                res.append(String.valueOf(table[i].symbol).repeat(Math.max(0, decimalValue / table[i].value)));
                decimalValue = 0;
            }
            else {
                res.append(table[i].symbol);
                decimalValue -= table[i].value;
            }
        }
        return res.toString();
    }

    private int getPowerOfTen(int power) {
        int r = 10;
        for (int i = 0; i < power - 1; i++) {
            r *= 10;
        }
        return r;
    }
}
