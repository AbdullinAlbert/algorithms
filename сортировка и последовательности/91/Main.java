import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        if (n < 6) {
            PrintWriter pw = new PrintWriter("output.txt");
            switch (n) {
                case 1:
                    pw.println(2);
                    pw.println(1);
                    break;
                case 2:
                    pw.println(3);
                    pw.println(5);
                    break;
                case 3:
                    pw.println(4);
                    pw.println(6);
                    break;
                case 4:
                    pw.println(7);
                    pw.println(8);
                    break;
                case 5:
                    pw.println(13);
                    pw.println(10);
                    break;
            }
            pw.close();
            return;
        }

        a[0] = 2;
        a[1] = 3;
        a[2] = 4;
        a[3] = 7;
        a[4] = 13;

        b[0] = 1;
        b[1] = 5;
        b[2] = 6;
        b[3] = 8;
        b[4] = 9;
        b[5] = 10;
        b[6] = 11;
        b[7] = 12;

        int j = 8;
        int i = 5;
        while (j < n) {
            a[i] = b[i - 1] + b[i - 3];
            for (int k = a[i - 1] + 1; (k < a[i]) && (j < n); k++, j++) b[j] = k;
            i++;
        }
        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(b[j - 2] + b[j - 4]);
        pw.println(b[j - 1]);
        pw.close();
    }
}
