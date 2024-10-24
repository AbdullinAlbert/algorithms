import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        String file = reader.readLine();
        short[] a = new short[5];
        short i = 0;
        for (String s : file.split(" ")) a[i++] = Short.parseShort(s);

        reader.close();

        insertionSort(a);

        short[] cardCount = new short[14];
        for (short s : a) cardCount[s]++;

        PrintWriter pw = new PrintWriter("output.txt");

        boolean hasThree = false;
        boolean hasTwo = false;
        short twoCount = 0;

        for (short count : cardCount) {
            if (count == 5) {
                pw.println("Impossible");
                pw.close();
                return;
            }
            if (count == 4) {
                pw.println("Four of a Kind");
                pw.close();
                return;
            }
            if (count == 3) hasThree = true;

            if (count == 2) {
                hasTwo = true;
                twoCount++;
            }
        }

        if (hasTwo & hasThree) {
            pw.println("Full House");
            pw.close();
            return;
        }
        if (hasThree) {
            pw.println("Three of a Kind");
            pw.close();
            return;
        }
        if (twoCount == 2) {
            pw.println("Two Pairs");
            pw.close();
            return;
        }

        if (twoCount == 1) {
            pw.println("One Pair");
            pw.close();
            return;
        }

        boolean isStraight = true;
        for (i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] != 1) isStraight = false;
        }

        if (isStraight) {
            pw.println("Straight");
            pw.close();
            return;
        }

        pw.println("Nothing");
        pw.close();

    }

    static void insertionSort(short[] a) {
        for (short i = 1; i <= a.length - 1; i++) {
            short key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                short h = a[j];
                a[j] = key;
                a[j + 1] = h;
                j--;
            }
        }
    }
}
