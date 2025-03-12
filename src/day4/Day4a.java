package day4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Day4a {
    public Day4a() {
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
                    if (table[i][j].equals("X")) {
                        result += isItAWord(table, i, j);
                    }
                }
            }
            return "This is your result of first task in day 4: " + result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int isItAWord(String[][] table, int i, int j) {
        int count = 0;
        try {
            int numToM = 1;
            int numToA = 2;
            int numToS = 3;
            int maxBorder = 4;
            //right
            if ((width - maxBorder) >= j && table[i][j + numToM].equals("M")) {
                if (table[i][j + numToA].equals("A")) {
                    if (table[i][j + numToS].equals("S")) {
                        count++;
                    }
                }
            }
            //left
            if ((maxBorder - 1) <= j && table[i][j - numToM].equals("M")) {
                if (table[i][j - numToA].equals("A")) {
                    if (table[i][j - numToS].equals("S")) {
                        count++;
                    }
                }
            }
            //up
            if ((maxBorder - 1) <= i && table[i - numToM][j].equals("M")) {
                if (table[i - numToA][j].equals("A")) {
                    if (table[i - numToS][j].equals("S")) {
                        count++;
                    }
                }
            }
            //down
            if ((height - maxBorder) >= i && table[i + numToM][j].equals("M")) {
                if (table[i + numToA][j].equals("A")) {
                    if (table[i + numToS][j].equals("S")) {
                        count++;
                    }
                }
            }
            //down, right
            if ((height - maxBorder) >= i && (width - maxBorder) >= j &&
                    table[i + numToM][j + numToM].equals("M")) {
                if (table[i + numToA][j + numToA].equals("A")) {
                    if (table[i + numToS][j + numToS].equals("S")) {
                        count++;
                    }
                }
            }
            //up, left
            if ((maxBorder - 1) <= i && (maxBorder - 1) <= j &&
                    table[i - numToM][j - numToM].equals("M")) {
                if (table[i - numToA][j - numToA].equals("A")) {
                    if (table[i - numToS][j - numToS].equals("S")) {
                        count++;
                    }
                }
            }
            //down, left
            if ((height - maxBorder) >= i && (maxBorder - 1) <= j &&
                    table[i + numToM][j - numToM].equals("M")) {
                if (table[i + numToA][j - numToA].equals("A")) {
                    if (table[i + numToS][j - numToS].equals("S")) {
                        count++;
                    }
                }
            }
            //up, right
            if ((maxBorder - 1) <= i && (width - maxBorder) >= j &&
                    table[i - numToM][j + numToM].equals("M")) {
                if (table[i - numToA][j + numToA].equals("A")) {
                    if (table[i - numToS][j + numToS].equals("S")) {
                        count++;
                    }
                }
            }
        }catch (IndexOutOfBoundsException e){
            System.err.println("Index out of bounds");
        }
        return count;
    }
}
