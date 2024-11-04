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
    static Random r = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int size = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[size];
        int i = 0;
        while (scanner.hasNext()) a[i++] = scanner.nextInt();

        quickSort(a, 0, a.length - 1);

        int j = 0;
        int s = 0;

        for (i = size - 1; (j < m) && (a[i] > 0); j++, i--) s += a[i];

        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(s);
        pw.close();
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        Pair p = partition(a, start, end);
        quickSort(a, start, p.l - 1);
        quickSort(a, p.r + 1, end);
    }

    static Pair partition(int[] a, int start, int end) {
        int p = r.nextInt(end - start + 1) + start;

        int h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;
        int eq = start;

        for (int j = start + 1; j <= end; j++) {
            if (a[j] < a[start]) {

                h = a[less + 1];
                a[less + 1] = a[j];
                a[j] = h;

                if (eq > less) {
                    h = a[eq + 1];
                    a[eq + 1] = a[j];
                    a[j] = h;
                }

                eq++;
                less++;
            } else if (a[j] == a[start]) {

                h = a[eq + 1];
                a[eq + 1] = a[j];
                a[j] = h;

                eq++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return new Pair(less, eq);
    }
}
