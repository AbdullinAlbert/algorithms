import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static class Letter {
        int index;
        char letter;

        Letter(char letter, int index) {
            this.letter = letter;
            this.index = index;
        }
    }

    static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Random r = new Random();

    static class Comparator {
        int compare(Letter l1, Letter l2) {
            return l1.letter - l2.letter;
        }
    }

    static Comparator comparator = new Comparator();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        String s = sc.nextLine();
        sc.close();
        Letter[] a = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Letter l = new Letter(s.charAt(i), i + 1);
            a[i] = l;
        }
        quickSort(a, 0, a.length - 1);
        PrintWriter pw = new PrintWriter("output.txt");
        for (int i = 0; i < a.length; i++) {
            int d = a[i].letter - 'A';
            if (i > d) {
                pw.println("NO");
                pw.close();
                return;
            }
        }
        pw.println("YES");
        for (Letter letter : a) pw.print(letter.index + " ");
        pw.close();
    }

    static void quickSort(Letter[] a, int start, int end) {
        if (start >= end) return;
        Pair p = partition(a, start, end);
        quickSort(a, start, p.left - 1);
        quickSort(a,p.right + 1, end);
    }

    static Pair partition(Letter[] a, int start, int end) {
        int p = r.nextInt(end - start + 1) + start;

        Letter h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;
        int eq = start;

        for (int j = start + 1; j <= end; j++) {
            int compare = comparator.compare(a[j], a[start]);
            if (compare < 0) {
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
            } else if (compare == 0) {
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
