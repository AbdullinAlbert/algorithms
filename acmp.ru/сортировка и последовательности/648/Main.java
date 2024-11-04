import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random r = new Random();

    static class Pair<T> {

        T l;
        T r;

        Pair(T l, T r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int size = sc.nextInt();
        int[] a = new int[size];
        int i = 0;
        while (sc.hasNext()) a[i++] = sc.nextInt();
        quickSort(a, 0, a.length - 1);
        int croupierSum = 0;
        int shrekSum = 0;
        int lI = a.length - 1;
        for (i = 0; i < a.length / 2; i++) {
            croupierSum += a[i];
            shrekSum += a[lI - i];
        }
        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(shrekSum - croupierSum);
        pw.close();
    }
    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;;
        Pair<Integer> p = partition(a, start, end);
        quickSort(a, start, p.l - 1);
        quickSort(a, p.r + 1, end);
    }

    static Pair<Integer> partition(int[] a, int start, int end) {
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
            }
            else if (a[j] == a[start]) {
                h = a[eq + 1];
                a[eq + 1] = a[j];
                a[j] = h;
                eq++;
            }
        }

        h = a[less];
        a[less] = a[start];
        a[start] = h;

        return new Pair<>(less, eq);
    }
}
