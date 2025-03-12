package day4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Day4b {

    public Day4b() {
    }

    private int height = 0;
    private int width;
    private int result;

    public String mainLogic() {
        try {
            String text;
            String[][] table;
            try (RandomAccessFile rAf = new RandomAccessFile("inputDay4.txt", "rw")) {
                while ((text = rAf.readLine()) != null) {
                    height++;
                    width = text.length();
                }
                table = new String[height][width];
                rAf.seek(0);
                int index = 0;
                while ((text = rAf.readLine()) != null) {
                    table[index] = text.split("");
                    index++;
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (table[i][j].equals("A")) {
                        if (isItACross(table, i, j)) result++;
                    }
                }
            }
            return "This is your result of second task in day 4: " + result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isItACross(String[][] table, int i, int j) {
        int maxBorder = 2;
        try {
            if ((width - maxBorder >= j) && (maxBorder - 1) <= j &&
                    (height - maxBorder >= i) && (maxBorder - 1) <= i) {
                /* M  M
                    A
                   S  S
                 */
                if (table[i - 1][j - 1].equals("S") && table[i - 1][j + 1].equals("S")) {
                    if (table[i + 1][j - 1].equals("M") && table[i + 1][j + 1].equals("M")) return true;
                }
                /* S  S
                    A
                   M  M
                 */
                if (table[i - 1][j - 1].equals("M") && table[i - 1][j + 1].equals("M")) {
                    if (table[i + 1][j - 1].equals("S") && table[i + 1][j + 1].equals("S")) return true;
                }
                /* S  M
                    A
                   S  M
                 */
                if (table[i - 1][j - 1].equals("S") && table[i + 1][j - 1].equals("S")) {
                    if (table[i + 1][j + 1].equals("M") && table[i - 1][j + 1].equals("M")) return true;
                }
                /* M  S
                    A
                   M  S
                 */
                if (table[i - 1][j - 1].equals("M") && table[i + 1][j - 1].equals("M")) {
                    if (table[i + 1][j + 1].equals("S") && table[i - 1][j + 1].equals("S")) return true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds");
        }
        return false;
    }
}
