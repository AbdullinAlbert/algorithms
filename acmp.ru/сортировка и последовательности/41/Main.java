import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("input.txt"));

        int maxSize = 201;
        int[] a = new int[maxSize];

        byte[] bytes = new byte[4096];



        int numberOfReadByte = bis.read(bytes);

        int currentIndex = 0;

        while (bytes[currentIndex] != 10) currentIndex++;

        StringBuilder sb = new StringBuilder();


        while (numberOfReadByte != -1) {

            if (currentIndex == numberOfReadByte) currentIndex = 0;

            while (currentIndex < numberOfReadByte) {
                byte currentByte = bytes[currentIndex];
                if (currentByte == 0) break;
                if (currentByte == 32) {
                    int sortIndex = Integer.parseInt(sb.toString());
                    a[sortIndex + 100]++;
                    sb.delete(0, sb.length());
                } else if ((currentByte >= 48 && currentByte <= 57) || currentByte == 45) {
                    sb.append(byteToChar(currentByte));
                }
                currentIndex++;
            }

            numberOfReadByte = bis.read(bytes);
        }

        if (!sb.isEmpty()) {
            int sortIndex = Integer.parseInt(sb.toString());
            a[sortIndex + 100]++;
        }

        bis.close();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"));
        PrintWriter pw = new PrintWriter(bos);

        for (int i = 0; i < maxSize; i++) {
            if (a[i] > 0) {
                String value = (i - 100) + " ";
                for (int j = 0; j < a[i]; j++) pw.print(value);
            }
        }

        pw.flush();
        pw.close();
    }

    static char byteToChar(byte b) {
        return switch (b) {
            case 45 -> '-';
            case 48 -> '0';
            case 49 -> '1';
            case 50 -> '2';
            case 51 -> '3';
            case 52 -> '4';
            case 53 -> '5';
            case 54 -> '6';
            case 55 -> '7';
            case 56 -> '8';
            case 57 -> '9';
            default -> throw new RuntimeException();
        };
    }

}
