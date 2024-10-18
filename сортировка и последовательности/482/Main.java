import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        scanner.close();

        int i = 0;

        int j = 1;

        PrintWriter pw = new PrintWriter("output.txt");

        while (i <= n) {
            for (int k = 1; k <= j; k++) {
                String s = String.valueOf(k);
                for (int h = 0; h < s.length(); h++) {
                    i++;
                    if (i == n) {
                        pw.println(s.charAt(h));
                        pw.close();
                        return;
                    }
                }
            }
            j++;
        }
    }
}
