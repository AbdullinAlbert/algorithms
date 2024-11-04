import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int size = scanner.nextInt();
        int[] a = new int[size];
        int i = 0;
        while (scanner.hasNext()) a[i++] = scanner.nextInt();

        scanner.close();

        int count = 0;
        for (i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] != 1) count++;
        }

        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(count);
        pw.close();
    }
}
