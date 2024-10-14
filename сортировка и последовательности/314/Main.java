import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random r = new Random();

    static Comparator<String> comparator = (s1, s2) -> {
        int minLength = Math.min(s1.length(), s2.length());
        int d = 0;
        int i = 0;
        while (d == 0 && i < minLength) {
            d = s1.charAt(i) - s2.charAt(i);
            i++;
        }
        if (d != 0) return d;
        return s1.length() - s2.length();
    };

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int size = scanner.nextInt();
        String n = String.valueOf(scanner.nextInt());
        scanner.close();

        String[] a = new String[size];

        for (int i = 0; i < size; i++) {
            int value = i + 1;
            a[i] = String.valueOf(value);
        }

        quickSort(a, 0, a.length - 1);

        int index = binarySearch(a, 0, a.length - 1, n);

        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(index);
        pw.close();

    }

    static int binarySearch(String[] a, int start, int end, String searchKey) {
        int m = start + ((end - start + 1) / 2);
        int compare = comparator.compare(searchKey, a[m]);
        if (compare == 0) return m + 1;
        return (compare < 0) ? binarySearch(a, start, m - 1, searchKey) : binarySearch(a, m + 1, end, searchKey) ;
    }

    static void quickSort(String[] a, int start, int end) {
        if (start >= end) return;
        int p = partition(a, start, end);
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    static int partition(String[] a, int start, int end) {
        int p = r.nextInt(end - start + 1) + start;

        String h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;

        for (int j = start; j <= end; j++) {
            int compare = comparator.compare(a[j], a[start]);
            if (compare < 0) {
                h = a[less + 1];
                a[less + 1] = a[j];
                a[j] = h;
                less++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return less;
    }
}
