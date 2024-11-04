import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
 
public class Main {
 
    static class Time {
        byte h;
        byte m;
        byte s;
 
        Time(byte h, byte m, byte s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }
    }
 
    static class Pair<T> {
        T l;
        T r;
 
        Pair(T l, T r) {
            this.l = l;
            this.r = r;
        }
 
    }
 
    static Random r = new Random();
 
    interface Comparator {
        int compare(Time t1, Time t2);
    }
 
    static Comparator comparator = ((t1, t2) -> {
       int d = t1.h - t2.h;
       if (d != 0) return d;
       d = t1.m - t2.m;
       if (d != 0) return d;
       return t1.s - t2.s;
    });
 
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        Time[] a = new Time[n];
        int i = 0;
        while (sc.hasNext()) {
            byte h = sc.nextByte();
            byte m = sc.nextByte();
            byte s = sc.nextByte();
            a[i++] = new Time(h, m, s);
        }
        quickSort(a, 0, a.length - 1);
        PrintWriter pw = new PrintWriter("output.txt");
        for (i = 0; i < n; i++) pw.println(a[i].h + " " + a[i].m + " " + a[i].s);
        pw.close();
    }
    static void quickSort(Time[] a, int start, int end) {
        if (start >= end) return;
        Pair<Integer> p = partition(a, start, end);
        quickSort(a, start, p.l - 1);
        quickSort(a, p.r + 1, end);
    }
 
    static Pair<Integer> partition(Time[] a, int start, int end) {
        int p = r.nextInt(end - start + 1) + start;
 
        Time h = a[start];
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
 
        return new Pair<>(less, eq);
    }
}