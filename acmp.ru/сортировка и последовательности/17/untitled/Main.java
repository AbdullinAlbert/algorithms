import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        short size = scanner.nextShort();
        short[] a = new short[size];

        a[0] = scanner.nextShort();

        for (int i = 1; i < a.length; i++) a[i] = scanner.nextShort();

        scanner.close();

        new Test().test();

        int res = new Solver().solve(a);


        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(res);
        pw.close();
    }

    static class Solver {
        int solve(short[] a) {

            short i = 1;
            short h = 1;
            int sectorSize = 0;
            int circleCount = 1;
            boolean isPotentialCircle = false;

            while (i < a.length - 1) {
                if (isPotentialCircle) {
                    boolean isEqual = a[h] == a[i];
                    if (isEqual) {
                        if (h == sectorSize - 1) {
                            h = 1;
                            circleCount++;
                            isPotentialCircle = false;
                        } else h++;
                    } else {
                        h = 1;
                        circleCount = 1;
                        sectorSize = 0;
                        isPotentialCircle = (a[i] == a[0]);
                        if (isPotentialCircle) sectorSize = i;
                    }
                } else {
                    isPotentialCircle = (a[i] == a[0]);
                    if (isPotentialCircle && sectorSize == 0) sectorSize = i;
                    if (isPotentialCircle) {
                        if (sectorSize == 1) {
                            circleCount++;
                            isPotentialCircle = false;
                        }
                    } else {
                        circleCount = 1;
                        sectorSize = 0;
                    }
                }
                i++;
            }

            return isPotentialCircle ? (a.length - 1) : ((a.length - 1) / circleCount);
        }
    }

    static class Test {
        void test() {

            short[] a = { 5, 3, 1, 3, 5, 2, 5, 3, 1, 3, 5, 2, 5 };
            int r = new Solver().solve(a);
            if (r != 6) throw new RuntimeException("1: " + r);

            a = new short[] { 1, 1, 1, 1 };
            r = new Solver().solve(a);
            if (r != 1) throw new RuntimeException("2: " + r);

            a = new short[] { 1, 2, 3, 1 };
            r = new Solver().solve(a);
            if (r != 3) throw new RuntimeException("3: " + r);

            a = new short[] { 1, 2, 3, 4, 1, 1, 1, 1, 1, 2, 3, 4, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("4: " + r);

            a = new short[] { 1, 2, 3, 4, 1, 2, 3, 4, 1, 1, 1, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("5: " + r);

            a = new short[] { 1, 1, 2, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("6: " + r);

            a = new short[] { 1, 1, 1, 2, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("7: " + r);

            a = new short[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("8: " + r);

            a = new short[] { 1, 2, 3, 1, 1, 2, 3, 1, 1 };
            r = new Solver().solve(a);
            if (r != 4) throw new RuntimeException("9: " + r);

            a = new short[] { 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1 };
            r = new Solver().solve(a);
            if (r != 6) throw new RuntimeException("10: " + r);

            a = new short[] { 1, 2, 2, 1, 1, 1, 2, 2, 1, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("11: " + r);

            a = new short[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("12: " + r);

            a = new short[] { 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("13: " + r);

            a = new short[] { 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2 };
            r = new Solver().solve(a);
            if (r != a.length - 1) throw new RuntimeException("14: " + r);

            a = new short[] { 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2 };
            r = new Solver().solve(a);
            if (r != 3) throw new RuntimeException("14: " + r);

            a = new short[] { 2, 3, 2, 3, 2, 3, 2 };
            r = new Solver().solve(a);
            if (r != 2) throw new RuntimeException("15: " + r);

            a = new short[] { 1, 2, 3, 1, 2, 1, 2, 3, 1, 2, 1 };
            r = new Solver().solve(a);
            if (r != 5) throw new RuntimeException("16: " + r);

            a = new short[] { 1, 2, 3, 1, 2, 1, 2, 3, 1, 2, 1};
            r = new Solver().solve(a);
            if (r != 5) throw new RuntimeException("17: " + r);

        }
    }

}
