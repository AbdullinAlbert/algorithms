import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

    }

    static Random r = new Random();

    static Comparator<Pair> comparator = (p1, p2) -> {
        int d = p1.value - p2.value;
        if (d != 0) return d;
        return p1.index - p2.index;
    };

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int size = scanner.nextInt();
        Pair[] sourceArray = new Pair[size];
        Pair[] helpArray = new Pair[size];
        int i = 0;
        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            Pair p = new Pair(i, value);
            sourceArray[i] = p;
            helpArray[i] = p;
            i++;
        }

        scanner.close();

        quickSort(helpArray, 0, helpArray.length - 1);

        PrintWriter pw = new PrintWriter("output.txt");

        int slide = helpArray[0].index;

        for (i = slide; i < size + slide; i++) {
            pw.print(sourceArray[i % size].value + " ");
        }
        pw.close();
    }



    static void quickSort(Pair[] a, int start, int end) throws FileNotFoundException {
        if (start >= end) return;
        int p = partition(a, start, end);
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    static int partition(Pair[] a, int start, int end) {
        int p = r.nextInt(end - start + 1) + start;

        Pair h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;

        for (int j = start + 1; j <= end; j++) {
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
