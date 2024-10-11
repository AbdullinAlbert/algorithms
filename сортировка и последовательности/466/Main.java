import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        sc.close();
        int s = f(n);
        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(s);
        pw.close();
    }

    static int f(int n) {
        if (n <= 1) return 1;
        if (n % 2 == 0) return f(n / 2);
        else return f(n / 2) + f((n / 2) + 1);
    }

}
