import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static class Pair {
        int l;
        int r;

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static class FractionalFormatRes {
        String fractional;
        boolean isNeedAddOne;

        FractionalFormatRes(String fractional, boolean isNeedAddOne) {
            this.fractional = fractional;
            this.isNeedAddOne = isNeedAddOne;
        }

    }

    static Random r = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int size = scanner.nextInt();
        long[] a = new long[size];
        for (int i = 0; i < size; i++) a[i] = scanner.nextLong();
        double resSum = scanner.nextDouble();

        scanner.close();

        quickSort(a, 0, a.length - 1);

        for (long l : a) if (resSum < l) resSum = (resSum + l) / 2;

        PrintWriter pw = new PrintWriter("output.txt");

        String stringResSum = String.valueOf(resSum);

        if (stringResSum.contains("E")) {
            int eIndex = stringResSum.indexOf('E');
            int intPartCount = Integer.parseInt(stringResSum.substring(eIndex + 1, eIndex + 2));
            String intPart = stringResSum.charAt(0) + stringResSum.substring(2, intPartCount + 2);
            String fractionalPart = stringResSum.substring(intPartCount + 2, eIndex);
            FractionalFormatRes res = formatFractionalPart(fractionalPart);
            if (res.isNeedAddOne) {
                intPart = String.valueOf(Integer.parseInt(intPart) + 1);
            }
            pw.print(intPart + "." + res.fractional);
        } else {
            String[] intAndFractional = stringResSum.split("\\.");
            FractionalFormatRes res = formatFractionalPart(intAndFractional[1]);
            if (res.isNeedAddOne) {
                String newIntPart = String.valueOf((Integer.parseInt(intAndFractional[0]) + 1));
                intAndFractional[0] = newIntPart;
            }
            pw.print(intAndFractional[0] + "." + res.fractional);
        }

        pw.close();
    }

    static FractionalFormatRes formatFractionalPart(String fraction) {
        if (fraction.length() < 6) {
            StringBuilder fractionBuilder = new StringBuilder(fraction);
            for (int i = fractionBuilder.length(); i < 6; i++) fractionBuilder.append("0");
            String f = fractionBuilder.toString();
            return new FractionalFormatRes(f, false);
        } else if (fraction.length() > 6) {
            StringBuilder fractionalPart = new StringBuilder(fraction.substring(0, 6));
            byte sevenDigit = Byte.parseByte(fraction.substring(6, 7));
            boolean isNeedAddOne = false;
            if (sevenDigit > 4) {
                String fPart = Integer.toString((Integer.parseInt(fractionalPart.toString()) + 1));
                if (fPart.length() > 6) {
                    isNeedAddOne = true;
                    fPart = "000000";
                }
                fractionalPart = new StringBuilder(fPart);
                while (fractionalPart.length() < 6) fractionalPart.insert(0, "0");
            }
            String f = fractionalPart.toString();
            return new FractionalFormatRes(f, isNeedAddOne);
        }
        return new FractionalFormatRes(fraction, false);
    }

    static void quickSort(long[] a, int start, int end) {
        if (start >= end) return;
        Pair p = partition(a, start, end);
        quickSort(a, start, p.l - 1);
        quickSort(a, p.r + 1, end);
    }

    static Pair partition(long[] a, int start, int end) {
        int p = r.nextInt(end - start + 1) + start;

        long h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;
        int eq = start;

        for (int i = start + 1; i <= end; i++) {
            if (a[i] < a[start]) {

                h = a[less + 1];
                a[less + 1] = a[i];
                a[i] = h;

                if (eq > less) {
                    h = a[eq + 1];
                    a[eq + 1] = a[i];
                    a[i] = h;
                }

                eq++;
                less++;
            } else if (a[i] == a[start]) {

                h = a[eq + 1];
                a[eq + 1] = a[i];
                a[i] = h;

                eq++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return new Pair(less, eq);
    }

}
