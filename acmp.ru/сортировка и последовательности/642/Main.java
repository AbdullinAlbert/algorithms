import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random r = new Random();

    static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int carsCount = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] a = new int[carsCount];
        int i = 0;
        while (scanner.hasNext()) a[i++] = scanner.nextInt();

        scanner.close();

        quickSort(a, 0, a.length - 1);

        i = 0;
        int count = 0;
        while (i < a.length && sum > 0) {
            sum -= a[i++];
            if (sum >= 0) count++;
        }

        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(count);
        pw.close();
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        Pair p = partition(a, start, end);
        quickSort(a, start, p.left - 1);
        quickSort(a, p.right + 1, end);
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

                less++;
                eq++;

            } else if (a[j] == a[start]) {

                h = a[less + 1];
                a[less + 1] = a[j];
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
