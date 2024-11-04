import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
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

        int a1 = 13;

        while (j < n) {
            int a2 = b[i - 1] + b[i - 3];
            for (int k = a1 + 1; (k < a2) && (j < n); k++, j++) b[j] = k;
            a1 = a2;
            i++;
        }
        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(b[j - 2] + b[j - 4]);
        pw.println(b[j - 1]);
        pw.close();
    }
}
