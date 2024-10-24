import java.io.*;
import java.util.Scanner;

public class Main {

    static class Contestant {
        float points;

        String sPoints;
        String name;

        Contestant(float points, String sPoints, String name) {
            this.sPoints = sPoints;
            this.points = points;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));

        byte roomsCount = scanner.nextByte();
        Contestant[] res = new Contestant[0];

        for (int i = 0; i < roomsCount; i++) {
            byte contestantsCount = scanner.nextByte();
            Contestant[] ha = new Contestant[contestantsCount];
            for (int j = contestantsCount - 1; j >= 0; j--) {
                String points = scanner.next();
                String name = scanner.next();
                ha[j] = new Contestant(Float.parseFloat(points), points, name);
            }
            res = mergeSort(res, ha);
        }

        scanner.close();

        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(res.length);
        for (int i = res.length - 1; i >= 0; i--) {
            pw.println(res[i].sPoints + " " + res[i].name);
        }
        pw.close();
    }

    static Contestant[] mergeSort(Contestant[] common, Contestant[] intermediate) {
        int size = common.length + intermediate.length;
        Contestant[] res = new Contestant[size];
        int f = 0;
        int s = 0;
        for (int i = 0; i < size; i++) {
            if (f > common.length - 1) {
                for (int j = s; j < intermediate.length; j++) {
                    res[i] = intermediate[j];
                    i++;
                }
                break;
            } else if (s > intermediate.length - 1) {
                for (int j = f; j < common.length; j++) {
                    res[i] = common[j];
                    i++;
                }
                break;
            }
            if (common[f].points <= intermediate[s].points) {
                res[i] = common[f];
                f++;
            } else {
                res[i] = intermediate[s];
                s++;
            }
        }
        return res;
    }
}
