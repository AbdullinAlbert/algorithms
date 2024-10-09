import java.util.Random;

public class Main {

    static class Pair<T, V> {
        T first;
        V second;
        Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10_000_000; i++) {
            for (int j = 0; j < a.length; j++) a[j] = r.nextInt(11);
            quickSort(a, 0, a.length - 1);
            try {
                for (int j = 0; j < a.length - 1; j++) assert a[j] <= a[j + 1];
                System.out.print(i + ": ok: ");
                for (int k : a) System.out.print(k + ", ");
                System.out.println();
            } catch (Exception e) {
                for (int k : a) System.out.print(k + ", ");
            }
        }
    }

    static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        Pair<Integer, Integer> p = partition(array, start, end);
        quickSort(array, start, p.first - 1);
        quickSort(array, p.second + 1, end);
    }

    static Pair<Integer, Integer> partition(int[] a, int start, int end) {
        int p = new Random().nextInt(end - start + 1) + start;

        int h = a[start];
        a[start] = a[p];
        a[p] = h;

        int less = start;
        int equal = start;

        for (int j = start + 1; j <= end; j++) {
            if (a[j] < a[start]) {

                h = a[less + 1];
                a[less + 1] = a[j];
                a[j] = h;

                if (equal > less) {
                    h = a[equal + 1];
                    a[equal + 1] = a[j];
                    a[j] = h;
                }

                less++;
                equal++;

            } else if (a[j] == a[start]) {
                h = a[equal + 1];
                a[equal + 1] = a[j];
                a[j] = h;
                equal++;
            }
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return new Pair<>(less, equal);
    }
}
